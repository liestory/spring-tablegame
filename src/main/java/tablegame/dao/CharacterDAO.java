package tablegame.dao;

import tablegame.model.Character;
import tablegame.model.CharacterStatus;
import tablegame.model.Characteristics;
import tablegame.model.CharacteristicsBase;
import tablegame.model.Inventory;

/**
 * DAO для работы с персонажен
 *
 * @author nemykin 07.12.2020
 */
public interface CharacterDAO extends GenericDAO<Character, Long> {

    /**
     * получение карточки персонажа по его имени
     *
     * @param characterName
     * @return
     */
    Character getCharacterByName(String characterName);

    /**
     * получение статуса персонажа по его имени
     *
     * @param characterName
     * @return
     */
    CharacterStatus getCharacterStatusByName(String characterName);

    /**
     * получение текущих характеристик персонажа по его имени
     * @param characterName
     * @return
     */
    Characteristics getCharacterCharacteristicsByName(String characterName);

    /**
     * получение базовых характеристик персонажа по его имени
     *
     * @param characterName
     * @return
     */
    CharacteristicsBase getCharacterCharacteristicsBaseByName(String characterName);

    /**
     * получение инвенторя персонажа по его имени
     * @param characterName
     * @return
     */
    Inventory getCharacterInventoryByName(String characterName);

    /**
     *  получение уровня персонажа по его имени
     *
     * @param characterName
     * @return
     */
    Integer getCharacterLevelByName(String characterName);

}
