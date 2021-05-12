package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * карточка инвенторя
 * Это все предметы которые есть у персонажа в сумке, в руках, и на нем
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
@Entity
@Table(schema = "tablegame", name = "inventory")
public class Inventory extends CreateAtIdentified implements Identified<UUID> {

    private static final long serialVersionUID = -7698387603871668041L;
    /**
     * id инвенторя
     */
    @Id
    @Column
    @GeneratedValue
    private UUID id;

    /**
     * количество слотов для предметов
     */
    private int countSlots;

    /**
     *  максимально переносимый весь в инвенторе (зависит от силы персонажа)
     */
    private int weightMax;
}
