package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Связка инвенторя и предмета
 *
 * @author nemykin 12.01.2021
 */
@Getter
@Setter
@ToString
@Entity
@Table(schema = "tablegame", name = "item_and_inventory")
public class ItemInInventory extends CreateAtIdentified implements Identified<UUID> {

    /**
     * id связки
     */
    @Id
    @Column
    private UUID id;

    /**
     * предмет
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    /**
     * инвентарь связанный с этим предметом
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
}
