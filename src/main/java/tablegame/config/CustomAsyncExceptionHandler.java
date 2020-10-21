package tablegame.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import tablegame.service.UserServiceImpl;

import java.lang.reflect.Method;

/**
 * CustomAsyncExceptionHandler.
 *
 * @author Ilya_Sukhachev
 */
public class CustomAsyncExceptionHandler
        implements AsyncUncaughtExceptionHandler {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.info("Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
    }

}
