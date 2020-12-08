package tablegame.dao;

import tablegame.model.Character;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;

import java.util.Map;
import java.util.UUID;

/**
 * методы работ с юзером
 *
 * @author nemykin 14.10.2020
 */
public interface UserDAO extends GenericDAO<User, UUID>{
    /**
     * Получить данные по юзер по логину
     * @param name
     * @return
     */
    User findPlayerByLogin(String name);

    /**
     * Получить роль у данного юзера по логину.
     *
     * @param name
     * @return
     */
    Role getRoleByLogin(String name);

    /**
     * получить всех персонажа по его логину
     *
     * @param name
     * @return
     */
    Map<Character, Game> getCharacterByLogin(String name);

}
