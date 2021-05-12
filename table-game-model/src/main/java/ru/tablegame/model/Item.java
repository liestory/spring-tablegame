package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * карточка предмета
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
@Entity
@Table(schema = "tablegame", name = "item")
public class Item extends CreateAtIdentified implements Identified<UUID>{

    /**
     * id предмета
     */
    @Id
    @Column
    @GeneratedValue
    private UUID id;

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
    @ToString.Exclude
    private ItemStatus itemStatus;
}
