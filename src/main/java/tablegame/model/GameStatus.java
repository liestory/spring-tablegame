package tablegame.model;

import javax.validation.constraints.NotNull;

/**
 * состояние игры (статусы)
 *
 * @author nemykin 07.12.2020
 */
public enum GameStatus {
    CREATED("Создана"),
    HOLD("Не активна"),
    PROCESSING("Запущена"),
    FINISHED("Закончена");

    private String description;

    GameStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static GameStatus getStatusByDesc(@NotNull String desc) {
        return GameStatus.valueOf(desc);
    }
}
