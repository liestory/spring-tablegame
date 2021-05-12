package ru.tablegame.auth.model;

import javax.validation.constraints.NotNull;

/**
 * глобальне роли в системе
 *
 * @author nemykin 19.03.2021
 */
public enum RoleGlobal {

    ADMIN("Админ"),
    SUPPORT("Поддержка"),
    PLAYER("Игрок"),
    GUEST("Гость");

    /**
     * описание состояния внутри его статуса.
     */
    private String description;

    RoleGlobal(String description) {
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
     * @return - enum RoleGlobal
     */
    public static RoleGlobal getStatusByDesc(@NotNull String desc) {
        for (RoleGlobal itemStatus : RoleGlobal.values()) {
            if (itemStatus.description.equals(desc)) {
                return itemStatus;
            }
        }
        return null;
    }
}
