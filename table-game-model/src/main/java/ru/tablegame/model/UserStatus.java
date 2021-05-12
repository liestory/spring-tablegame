package ru.tablegame.model;

import javax.validation.constraints.NotNull;

/**
 * статусы пользователей на играх
 *
 * @author nemykin 14.10.2020
 */
public enum UserStatus {
    STATUS_ACTIVED("Активен"),
    STATUS_OBSERVER("Наблюдатель"),
    STATUS_LOCKED("Заблокирован");

    /**
     * словетное описание статуса пользователя на играх.
     */
    private String description;

    UserStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * получить статус по его описания
     * необходимо для мапинга значения приходящих с фронта
     *
     * @param desc -  описание состояния
     * @return - enum UserStatus
     */
    public static UserStatus getStatusByDesc(@NotNull String desc) {
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.description.equals(desc)) {
                return userStatus;
            }
        }
        return null;
    }
}
