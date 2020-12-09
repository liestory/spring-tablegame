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
     * @param characterName - имя персонажа
     * @return - карточка персонажа
     */
    Character getCharacterByName(String characterName);

    /**
     * получение статуса персонажа по его имени
     *
     * @param characterName - имя персонажа
     * @return - статус персонажа
     */
    CharacterStatus getCharacterStatusByName(String characterName);

    /**
     * получение текущих характеристик персонажа по его имени
     *
     * @param characterName - имя персонажа
     * @return - текущие характеристики персонажа
     */
    Characteristics getCharacterCharacteristicsByName(String characterName);

    /**
     * получение базовых характеристик персонажа по его имени
     *
     * @param characterName - имя персонажа
     * @return - базовые характеристики персонажа
     */
    CharacteristicsBase getCharacterCharacteristicsBaseByName(String characterName);

    /**
     * получение инвенторя персонажа по его имени
     *
     * @param characterName - имя персонажа
     * @return - инвентарь персонажа
     */
    Inventory getCharacterInventoryByName(String characterName);

    /**
     * получение уровня персонажа по его имени
     *
     * @param characterName - имя персонажа
     * @return - уровень персонажа
     */
    Integer getCharacterLevelByName(String characterName);

}
