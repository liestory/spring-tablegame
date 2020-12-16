package ru.tablegame.model;

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

    /**
     * словесное описание статуса
     */
    private String description;

    GameStatus(String description) {
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
     * @return - enum GameStatus
     */
    public static GameStatus getStatusByDesc(@NotNull String desc) {
        for (GameStatus gameStatus : GameStatus.values()) {
            if (gameStatus.description.equals(desc)) {
                return gameStatus;
            }
        }
        return null;
    }
}
