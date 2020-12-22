package ru.tablegame.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * SpringConfig
 *
 * @author nemykin 20.10.2020
 */
@Configuration
@ComponentScan("ru.tablegame")
@EnableAsync
@PropertySource(value = {"classpath:application.properties"})
public class SpringConfig {

    @Value("${threadPool.corePoolSize}")
    private String corePoolSize;

    @Value("${threadPool.maxPoolSize}")
    private String maxPoolSize;

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(4);
        threadPoolTaskExecutor.setMaxPoolSize(8);
        threadPoolTaskExecutor.initialize();
        threadPoolTaskExecutor.setCorePoolSize(Integer.parseInt(corePoolSize));
        threadPoolTaskExecutor.setMaxPoolSize(Integer.parseInt(maxPoolSize));
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
