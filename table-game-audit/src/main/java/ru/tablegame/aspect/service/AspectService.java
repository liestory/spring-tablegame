package ru.tablegame.aspect.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import ru.tablegame.aspect.annotation.Audit;
import ru.tablegame.aspect.model.AuditEvent;
import ru.tablegame.aspect.model.AuditMessage;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author nemykin 01.03.2021
 */
@Aspect
@Slf4j
@Component
@AllArgsConstructor
public class AspectService {

    private final AuditService auditService;

    @Pointcut("@annotation(ru.tablegame.aspect.annotation.Audit) && execution(public * *(..))")
    public void publicAspectMethod() {
    }

    /**
     * Метод определяющий порядок аудита основанный на аспектах
     *
     * @param joinPoint - точка входа
     * @return joinPoint.proceed()
     * @throws Throwable
     */
    @Around(value = "publicAspectMethod()")
    public Object aspect(ProceedingJoinPoint joinPoint) throws Throwable {
        AuditMessage auditEvent = new AuditMessage();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Audit annotation = method.getAnnotation(Audit.class);
        Validate.notNull(annotation);
        auditEvent.setAuditCode(annotation.value());
        auditEvent.setAuditEvent(AuditEvent.START);
        auditEvent.setStartTime(LocalDateTime.now());
        Object[] params = Arrays.stream(joinPoint.getArgs())
                .filter(obj -> !(obj instanceof UriComponentsBuilder))
                .toArray();
        auditEvent.setParams(toJsonString(params));
        log.info(auditEvent.toString());
        Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable thr) {
            auditEvent.setAuditEvent(AuditEvent.FAILURE);
            endAuditEvent(auditEvent, thr);
            throw thr;
        }
        auditEvent.setAuditEvent(AuditEvent.SUCCESS);
        endAuditEvent(auditEvent, proceed);
        return proceed;
    }

    /**
     * Метод отвечающий за логику завершения события аудита
     *
     * @param auditMessage - событие аудита
     * @param result       - результат выполнения события аудита, или ошибка
     */
    private void endAuditEvent(AuditMessage auditMessage, Object result) {
        auditMessage.setEndTime(LocalDateTime.now());
        auditMessage.setResult(toJsonString(result));
        auditService.addAutidMessage(auditMessage);
        log.info(auditMessage.toString());
    }

    /**
     * Метод преобразования в строку в формате JSON
     *
     * @param o - json объект для парсинга
     * @return строка после парсинга
     */
    private String toJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (o instanceof Throwable) {
                Throwable thr = (Throwable) o;
                return objectMapper.writeValueAsString(thr.getMessage());
            }
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

