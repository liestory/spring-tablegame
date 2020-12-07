package tablegame.model;

/**
 * состояние предмета
 *
 * @author nemykin 07.12.2020
 */
public class Item {
    private long id;
    private String item;
    private int weight;
    private ItemStatus itemStatus;
    private int durability;
    private boolean possibleRepair;
}
