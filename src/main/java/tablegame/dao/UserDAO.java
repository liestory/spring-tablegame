package tablegame.dao;

import tablegame.model.Role;
import tablegame.model.User;

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


}
