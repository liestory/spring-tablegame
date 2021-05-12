package ru.tablegame.model;

import javax.validation.constraints.NotNull;

/**
 * состояние персонажа внутри игры
 * ВАЖНО! персонаж не существет отдельно от игры.
 *
 * @author nemykin 07.12.2020
 */
public enum CharacterStatus {
    CREATE("Создан"),
    HOLD("Не активен"),
    ACTIVE("Активен"),
    IN_BATTLE("В бою"),
    IN_REST("В зоне отдыха"),
    DEAD("Мертв");

    /**
     * словесное описание статуса
     */
    private String description;

    CharacterStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * получить статус по его описанию
     * необходимо для мапинга значения приходящих с фронта
     *
     * @param desc -  описание состояния
     * @return - enum CharacterStatus
     */
    public static CharacterStatus getStatusByDesc(@NotNull String desc) {
        for (CharacterStatus characterStatus : CharacterStatus.values()) {
            if (characterStatus.description.equals(desc)) {
                return characterStatus;
            }
        }
        return null;
    }
}
