package tablegame.model;

import lombok.Setter;

/**
 * игровые персонажи
 * В принципе персонаж живет только у пользователя в рамках 1 игры. Персонажы всегда связанны с игрой
 *
 * @author nemykin 07.12.2020
 */
@Setter
public class Character implements Identified<Long> {

    /**
     * id персонажа
     */
    private Long id;

    /**
     * имя персонажа
     */
    private String characterName;

    /**
     * статус пресонажа для определения его состояния
     */
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
    private CharacteristicsBase characteristicsBase;

    /**
     * конечные характеристики по всем формулам.
     */
    private Characteristics characteristics;
    private Inventory inventory;

    public Character() {
        this.characterStatus = CharacterStatus.CREATE;
    }

    public Character(Long id, String characterName) {
        this();
        this.id = id;
        this.characterName = characterName;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public CharacterStatus getCharacterStatus() {
        return characterStatus;
    }

    public int getLevel() {
        return level;
    }

    public CharacteristicsBase getCharacteristicsBase() {
        return characteristicsBase;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
