package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * карточки ошибки.
 *
 * @author nemykin 29.10.2020
 */
@Getter
@Setter
public class ResponseError {
    /**
     * id ошибки
     */
    private UUID id;

    /**
     * сообщение об ошибке
     */
    private String message;

    /**
     * код ошибки
     */
    private String codeError;

    /**
     * имя моей системы
     */
    private String systemName;

    public ResponseError(UUID id, String message, String codeError, String systemId) {
        this.id = id;
        this.message = message;
        this.codeError = codeError;
        this.systemName = systemId;
    }
}
