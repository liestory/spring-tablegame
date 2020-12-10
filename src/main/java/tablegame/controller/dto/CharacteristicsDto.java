package tablegame.controller.dto;

import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;

/**
 * @author nemykin 09.12.2020
 */
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

    /**
     * список ошибок
     */
    private List<ObjectError> errors;

    public CharacteristicsDto() {
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligent() {
        return intelligent;
    }

    public void setIntelligent(int intelligent) {
        this.intelligent = intelligent;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, dexterity, constitution, intelligent, wisdom, charisma);
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
