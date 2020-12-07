package tablegame.model;

import javax.validation.constraints.NotNull;

/**
 * @author nemykin 07.12.2020
 */
public enum CharacterStatus {
    CREATE("Создан"),
    HOLD("Не активен"),
    ACTIVE("Активен"),
    IN_BATTLE("В бою"),
    IN_REST("В зоне отдыха"),
    DEAD("Мертв");

    private String description;

    CharacterStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CharacterStatus getStatusByDesc(@NotNull String desc) {
        return CharacterStatus.valueOf(desc);
    }
}
