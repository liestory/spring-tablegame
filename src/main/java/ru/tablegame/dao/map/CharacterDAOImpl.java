package ru.tablegame.dao.map;

import org.springframework.stereotype.Repository;
import ru.tablegame.dao.CharacterDAO;
import ru.tablegame.model.Character;
import ru.tablegame.model.CharacterStatus;
import ru.tablegame.model.Characteristics;
import ru.tablegame.model.CharacteristicsBase;
import ru.tablegame.model.Inventory;

import java.util.HashMap;

/**
 * @author nemykin 07.12.2020
 */
@Repository
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
