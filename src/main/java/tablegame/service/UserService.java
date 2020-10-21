package tablegame.service;

import tablegame.model.Role;
import tablegame.model.User;

/**
 * @author Asus 14.10.2020
 */
public interface UserService {
    /**
     * добавить пользователя
     *
     * @param user
     */
    void addUser(User user);

    /**
     *  добавить роль
     *
     * @param user
     */
    void addRole(User user, Role role);
}
