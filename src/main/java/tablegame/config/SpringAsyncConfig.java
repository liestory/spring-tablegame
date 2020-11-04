package tablegame.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SpringAsyncConfig.
 *
 * @author nemykin 04.1.2020
 */
@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {

}
