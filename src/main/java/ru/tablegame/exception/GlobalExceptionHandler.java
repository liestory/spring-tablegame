package ru.tablegame.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tablegame.controller.dto.ResponseError;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * глобальная обработка ошибок в система
 *
 * @author nemykin 29.10.2020
 */
@RestControllerAdvice(basePackages = "ru.tablegame.controller")
@PropertySource(value = {"classpath:application.properties"})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${system.name}")
    private String systemName;

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(NullPointerException e) {
        ResponseError responseError = new ResponseError(UUID.randomUUID(),
                e.getMessage(),
                "Отсутсвует значение. исправте и попройте запрос заново",
                systemName);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(InvocationTargetException.class)
    public ResponseEntity<ResponseError> invocationTargetException(InvocationTargetException e) {
        ResponseError responseError = new ResponseError(UUID.randomUUID(),
                e.getMessage(),
                "Отсутсвует значение. исправте и попройте запрос заново",
                systemName);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException e) {
        ResponseError responseError = new ResponseError(UUID.randomUUID(),
                e.getMessage(),
                "Некорректное значение. исправте и попройте запрос заново",
                systemName);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException e) {
        ResponseError responseError = new ResponseError(UUID.randomUUID(),
                e.getMessage(),
                "Неизвестная ошибка. Попробуйте позже",
                systemName);
        return new ResponseEntity<>(responseError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
