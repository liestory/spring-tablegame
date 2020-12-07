package tablegame.dao.map;

import tablegame.dao.CharacterDAO;
import tablegame.model.Character;
import tablegame.model.CharacterStatus;
import tablegame.model.Characteristics;
import tablegame.model.CharacteristicsBase;
import tablegame.model.Inventory;

import java.util.HashMap;

/**
 * @author nemykin 07.12.2020
 */
public class CharacterDAOImpl extends AbstractDao<Character, Long> implements CharacterDAO {

    public CharacterDAOImpl() {
        super(Character.class, new HashMap<>());
    }

    @Override
    public Character getCharacterByName(String characterName) {
        for (Character element : elements.values()) {
            if (element.getCharacterName().equals(characterName)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public CharacterStatus getCharacterStatusByName(String characterName) {
        for (Character element : elements.values()) {
            if (element.getCharacterName().equals(characterName)) {
                return element.getCharacterStatus();
            }
        }
        return null;
    }

    @Override
    public Characteristics getCharacterCharacteristicsByName(String characterName) {
        for (Character element : elements.values()) {
            if (element.getCharacterName().equals(characterName)) {
                return element.getCharacteristics();
            }
        }
        return null;
    }

    @Override
    public CharacteristicsBase getCharacterCharacteristicsBaseByName(String characterName) {
        for (Character element : elements.values()) {
            if (element.getCharacterName().equals(characterName)) {
                return element.getCharacteristicsBase();
            }
        }
        return null;
    }

    @Override
    public Inventory getCharacterInventoryByName(String characterName) {
        for (Character element : elements.values()) {
            if (element.getCharacterName().equals(characterName)) {
                return element.getInventory();
            }
        }
        return null;
    }

    @Override
    public Integer getCharacterLevelByName(String characterName) {
        for (Character element : elements.values()) {
            if (element.getCharacterName().equals(characterName)) {
                return element.getLevel();
            }
        }
        return null;
    }
}
