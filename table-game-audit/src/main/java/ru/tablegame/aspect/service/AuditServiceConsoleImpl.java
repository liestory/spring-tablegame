package ru.tablegame.aspect.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.tablegame.aspect.model.AuditMessage;

/**
 * @author nemykin 30.03.2021
 */
@Service
@Slf4j
@AllArgsConstructor
@ConditionalOnProperty(prefix = "audit", name = "service", havingValue = "console")
public class AuditServiceConsoleImpl implements AuditService {

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public void addAutidMessage(AuditMessage auditMessage) {
        log.info(new ObjectMapper().writeValueAsString(auditMessage));
    }
}
