package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;

/**
 * характеристики активные всегда у персонажа
 * ВАЖНО! при изменении базовых характеристик, эти всегда пересчитываются
 * ВАЖНО! при надевании item влияющих на характеристи, перечитываются активные, а не базовые
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
public class Characteristics {
    /**
     * сила персонажа со всем его бонусами
     * влияет на рукопашные показатели
     */
    private int strength;

    /**
     * ловкость персонажа со всем его бонусами
     * влияет на показатели дальнего боя и защиту
     */
    private int dexterity;

    /**
     * конституция песонажа со всем его бонусами
     * показатель устойчивости и здоровья
     */
    private int constitution;

    /**
     * интелект персонажа со всем его бонусами
     * показатель количества навыков
     */
    private int intelligent;

    /**
     * мудрость персонажа со всем его бонусами
     * показатель колличества сопротивления заклинаниям
     */
    private int wisdom;

    /**
     * харизма персонажа со всем его бонусами
     * показатель способности очаровать
     */
    private int charisma;
}
