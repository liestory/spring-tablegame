package tablegame.model;

import java.util.List;

/**
 * состояние инвентаря
 *
 * @author nemykin 07.12.2020
 */
public class Inventory {
    private long id;
    private List<Item> item;
    private int countSlots;
    private ItemStatus itemStatus;
}
