package tablegame.model;

import lombok.Getter;
import lombok.Setter;

/**
 * карточка предмета
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
public class Item {

    /**
     * id предмета
     */
    private long id;

    /**
     * название предмета
     */
    private String item;

    /**
     * вес предмета
     */
    private int weight;

    /**
     * текущая прочность предмета.
     * При повреждения просность опускается к 0
     * Если прочность == 0, предмет нельзя использовать.
     */
    private int durability;

    /**
     * максимальная прочность предмета
     */
    private int durabilityMax;

    /**
     * возможность восстановить предмет при текущей прочности durability ниже durabilityMax
     */
    private boolean possibleRepair;

    /**
     * состояние предмета
     */
    private ItemStatus itemStatus;
}
