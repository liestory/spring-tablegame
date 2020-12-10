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
     *
     * @param name - логин пользователя
     * @return - карточка юзера
     */
    User findPlayerByLogin(String name);

    /**
     * Получить роль у данного юзера по логину.
     *
     * @param name     - логин пользователя
     * @param gameName - название игры
     * @return - роль юзера в текущей игре
     */
    Role getRoleByLogin(String name, String gameName);

    /**
     * получить всех персонажа по его логину
     *
     * @param name -  логин пользователя
     * @return -  список карточек персонажа c привязкой к играм
     */
    Map<Game, Character> getCharacterByLogin(String name);

    /**
     * получить список персонажей по его
     *
     * @param userId   - id юзера в системе
     * @param gameName - название игры
     * @return - список карточек персонажа c привязкой к играм
     */
    Map<Game, Character> getCharacterByUserIdAndGameName(UUID userId, String gameName);

    /**
     * получить список персонажей по его
     *
     * @param userName - логин пользователя
     * @param gameName - название игры
     * @return - список карточек персонажа c привязкой к играм
     */
    Map<Game, Character> getCharacterByUserNameAndGameName(String userName, String gameName);
}
