package ru.tablegame.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * обработка ошибок при async.
 * просто вывод в лог
 *
 * @author nemykin 23.12.2020
 */
@Slf4j
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.error("Exception message - {}", throwable.getMessage());
        log.error("Method name - {}", method.getName());
    }

}
