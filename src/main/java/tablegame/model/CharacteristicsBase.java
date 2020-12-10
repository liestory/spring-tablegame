package tablegame.model;

import lombok.Getter;
import lombok.Setter;

/**
 * характеристики персонажей базовые
 * ВАЖНО! при изменении базовых характеристик, эти всегда пересчитать активные характеристики
 * TODO: пока нужны по моей логике. Продумаю поулчше чтобы избавиться от дубля
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
public class CharacteristicsBase {
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

    public CharacteristicsBase(int strength, int dexterity, int constitution, int intelligent, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligent = intelligent;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }
}
