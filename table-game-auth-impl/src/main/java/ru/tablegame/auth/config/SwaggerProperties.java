package ru.tablegame.auth.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  проперти для конфигов Swagger
 *
 * @author nemykin 02.02.2021
 */
@Component
@ConfigurationProperties(prefix = "swagger")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SwaggerProperties {

    /**
     * Название проекта
     */
    private String title;

    /**
     * Описание
     */
    private String description;

    /**
     * Контактное лицо
     */
    private Contact contact = new Contact();

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Contact {

        private String name;

        private String url;

        private String mail;

    }
}
