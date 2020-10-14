package tablegame.dao;

import tablegame.model.User;
import tablegame.model.Role;

import java.util.UUID;

/**
 * @author nemykin 14.10.2020
 */
public interface UserDAO extends GenericDAO<User, UUID>{
    /**
     * Получить
     * @param name
     * @return
     */
    User findPlayerByLogin(String name);

    /**
     *  Получить все роли у данного юзера по логину.
     * @param name
     * @return
     */
    Role getRoleByLogin(String name);


}
