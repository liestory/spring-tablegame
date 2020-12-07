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
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligent;
    private int wisdom;
    private int charisma;
}
