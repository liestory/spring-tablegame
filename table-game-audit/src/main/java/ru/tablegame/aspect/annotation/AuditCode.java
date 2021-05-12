package ru.tablegame.aspect.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * Список аудит кодов по операциям.
 *
 * @author nemykin 01.03.2021
 */
@AllArgsConstructor
@Getter
public enum AuditCode {

    USER_CREATE("Создание пользователя"),
    USER_UPDATE("Обновление пользователя"),
    USER_GET("Получение пользователей"),
    USER_DELETE("Удаление юзеров"),

    GAME_CREATE("Создание игры"),
    GAME_UPDATE("Обновление игры"),
    GAME_GET("Получние игр"),
    GAME_DELETE("Удаление игры"),

    CHARACTER_CREATE("Создание персонажа"),
    CHARACTER_UPDATE("Обновление персонажа"),
    CHARACTER_GET("Получение персонажей"),
    CHARACTER_DELETE("Удаление персонажа"),
    CHARACTER_CHANGE_STATUS("Изменения статуса персонажа"),

    AUTH_CREATE("Создание токена");

    /**
     * описание кода аудита
     */
    private String description;

    /**
     * получить аудит код по его описанию
     * необходимо для мапинга значения приходящих с фронта
     *
     * @param desc -  описание состояния
     * @return - enum AuditCode
     */
    public static AuditCode getAuditCodeByDesc(@NotNull String desc) {
        for (AuditCode auditCode : AuditCode.values()) {
            if (auditCode.description.equals(desc)) {
                return auditCode;
            }
        }
        return null;
    }
}
