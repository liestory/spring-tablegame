package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * карточка инвенторя
 * Это все предметы которые есть у персонажа в сумке, в руках, и на нем
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
public class Inventory {
    /**
     * id инвенторя
     */
    private long id;
    /**
     * список предметов в инвенторе
     */
    private List<Item> item;

    /**
     * количество слотов для предметов
     */
    private int countSlots;

    /**
     *  максимально переносимый весь в инвенторе (зависит от силы персонажа)
     */
    private int weightMax;
}
