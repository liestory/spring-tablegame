package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;

/**
 * получение карточки характеристик персонажа для контролеров
 *
 * @author nemykin 09.12.2020
 */
@Getter
@Setter
public class CharacteristicsDto {

    /**
     * имя персонажа
     */
    private String characterName;

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

    public CharacteristicsDto() {
    }

    public CharacteristicsDto(String characterName, int strength, int dexterity, int constitution, int intelligent, int wisdom, int charisma) {
        this.characterName = characterName;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligent = intelligent;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, dexterity, constitution, intelligent, wisdom, charisma);
    }
}
