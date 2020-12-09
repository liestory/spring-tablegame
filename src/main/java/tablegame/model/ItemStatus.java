package tablegame.model;

import javax.validation.constraints.NotNull;

/**
 * состояние вещи в инвентаре
 * в зависимости от состояния вещи, потребуется разное время на ее использования в ходе боя/социального действия
 *
 * @author nemykin 07.12.2020
 */
public enum ItemStatus {
    IN_HAND("В руках"),
    EQUIP("На персонажен"),
    BAG("В сумке");

    /**
     * описание состояния внутри его статуса.
     */
    private String description;

    ItemStatus(String description) {
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
     * @return
     */
    public static ItemStatus getStatusByDesc(@NotNull String desc) {
        return ItemStatus.valueOf(desc);
    }
}
