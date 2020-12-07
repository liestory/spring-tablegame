package tablegame.dao;

import tablegame.model.User;
import tablegame.model.Role;

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
     *  Получить роль у данного юзера по логину.
     * @param name
     * @return
     */
    Role getRoleByLogin(String name);


}
