package tablegame.model;

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
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligent;
    private int wisdom;
    private int charisma;
}
