package tablegame.service;

import tablegame.model.Character;
import tablegame.model.CharacteristicsBase;
import tablegame.model.Game;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;
import tablegame.model.UserStatus;

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
     * добавить роль
     *
     * @param user
     */
    void addRole(User user, Role role, Game game);

    /**
     *  изменить роль пользователю роль
     *
     * @param user
     */
    void changeRole(User user, Role role);

    /**
     * изменить статус пользователя пользователю роль
     *
     * @param user
     */
    void changeStatus(User user, UserStatus status);

    /**
     * создать персонажа пользователю
     *
     * @param user
     * @param game
     * @return
     */
    void createCharacterByUser(User user, Game game);
}
