package tablegame.model;

import javax.validation.constraints.NotNull;

/**
 * состояние вещи в инвентаре
 *
 * @author nemykin 07.12.2020
 */
public enum ItemStatus {
    IN_HAND("В руках"),
    EQUIP("На персонажен"),
    BAG("В сумке");

    private String description;

    ItemStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ItemStatus getStatusByDesc(@NotNull String desc) {
        return ItemStatus.valueOf(desc);
    }
}
