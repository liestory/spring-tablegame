package tablegame.dao;

import tablegame.model.User;
import tablegame.model.Role;

/**
 * @author nemykin 14.10.2020
 */
public interface UserDAO {
    /**
     *  Получить 
     * @param name
     * @return
     */
    User findPlayerByLogin(String name);

    Role getRoleByLogin(String name);


}
