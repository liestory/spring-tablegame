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
 * характеристики персонажей базовые
 * ВАЖНО! при изменении базовых характеристик, эти всегда пересчитать активные характеристики
 * TODO: пока нужны по моей логике. Продумаю поулчше чтобы избавиться от дубля
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
@ToString
@Entity
@Table(schema = "tablegame", name = "characteristicbase")
public class CharacteristicsBase extends CreateAtIdentified implements Identified<UUID> {

    private static final long serialVersionUID = 4426374537504301362L;
    /**
     * id записи
     */
    @Id
    @Column
    @GeneratedValue
    private UUID id;

    /**
     * сила персонажа
     * влияет на рукопашные показатели
     * ВАЖНО! при создании персонажа не более 18
     */
    private int strength;

    /**
     * ловкость персонажа
     * влияет на показатели дальнего боя и защиту
     * ВАЖНО! при создании персонажа не более 18
     */
    private int dexterity;

    /**
     * конституция песонажа
     * показатель устойчивости и здоровья
     * ВАЖНО! при создании персонажа не более 18
     */
    private int constitution;

    /**
     * интелект персонажа
     * показатель количества навыков
     * ВАЖНО! при создании персонажа не более 18
     */
    private int intelligent;

    /**
     * мудрость персонажа
     * показатель колличества сопротивления заклинаниям
     * ВАЖНО! при создании персонажа не более 18
     */
    private int wisdom;

    /**
     * харизма персонажа
     * показатель способности очаровать
     * ВАЖНО! при создании персонажа не более 18
     */
    private int charisma;

}
