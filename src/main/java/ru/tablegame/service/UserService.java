package ru.tablegame.service;

import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;
import tablegame.controller.dto.CharacterDto;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;
import tablegame.model.UserStatus;

import java.util.List;
import java.util.UUID;

/**
 * @author Asus 14.10.2020
 */
public interface UserService {
    /**
     * добавить пользователя
     *
     * @param user - карточка юзера
     */
    void addUser(User user);

    /**
     * добавить роль
     *
     * @param user - карточка юзера
     * @param role - статус юзера который для изменения
     * @param game - карточка игры
     */
    void addRole(User user, Role role, Game game);

    /**
     * изменить роль пользователю роль
     *
     * @param user - карточка юзера
     * @param role - статус юзера который для изменения
     * @param game - карточка игры
     */
    void changeRole(User user, Role role, Game game);

    /**
     * изменить статус пользователя пользователю роль
     *
     * @param user   - карточка юзера
     * @param status - статус юзера который для изменения
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

    /**
     * получения карточки персонажа по id юзеру и названию игры
     *
     * @param userName - логин юзера
     * @param gameName - название игры
     * @return -  список карточек персонажа
     */
    List<CharacterDto> getCharacterByUserNameAndGameName(String userName, String gameName);
}
