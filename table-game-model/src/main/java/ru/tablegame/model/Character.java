package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * игровые персонажи
 * В принципе персонаж живет только у пользователя в рамках 1 игры. Персонажы всегда связанны с игрой
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
@ToString
@Entity
@Table(schema = "tablegame", name = "character")
public class Character extends CreateAtIdentified implements Identified<UUID> {

    /**
     * id персонажа
     */
    @Id
    @Column
    @GeneratedValue
    private UUID id;

    /**
     * юзер которому принадлежит данный персонаж
     */
//    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private String userId;

    /**
     * игра в рамках которой существует данный песонаж
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    /**
     * имя персонажа
     */
    @Column(name = "character_name")
    private String characterName;

    /**
     * статус пресонажа для определения его состояния
     */
    @Enumerated(EnumType.STRING)
    private CharacterStatus characterStatus;

    /**
     * уровень персонажа
     * От уровня зависит прирост по формулам конечных характеристик
     */
    private int level;

    /**
     * базовые характеристики.
     * ВАЖНО!Не должны менять в зависимости от экипировки
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristicbase_id")
    private CharacteristicsBase characteristicsBase;

    /**
     * конечные характеристики по всем формулам.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristic_id")
    private Characteristics characteristics;

    /**
     * инвентарь персонажа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public Character() {
        this.characterStatus = CharacterStatus.CREATE;
    }

    public Character(Game game) {
        this();
        this.game = game;
    }

    public Character(UUID id, String characterName, int level, CharacteristicsBase characteristicsBase, String userId) {
        this();
        this.id = id;
        this.characterName = characterName;
        this.level = level;
        this.characteristicsBase = characteristicsBase;
        this.userId = userId;
    }
}
