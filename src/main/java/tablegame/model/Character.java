package tablegame.model;

import lombok.Getter;
import lombok.Setter;


/**
 * Игровые персонажи
 *
 * @author nemykin 07.12.2020
 */
@Getter
@Setter
public class Character implements Identified<Long> {

    private Long id;
    private String characterName;
    private CharacterStatus characterStatus;
    private int level;
    private CharacteristicsBase characteristicsBase;
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
}
