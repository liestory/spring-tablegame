package ru.tablegame.service;

import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.controller.dto.UserDto;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;
import ru.tablegame.model.UserStatus;

import java.util.List;
import java.util.UUID;

/**
 * сервис по работе с юзерами
 *
 * @author Asus 14.10.2020
 */
public interface UserService {

    /**
     * регистрация пользователя
     *
     * @param userDto - карточка пользователя с формы регистрации
     * @return
     */
    UserDto regUser(UserDto userDto);

    /**
     * поиск пользователя
     *
     * @param id - id юзера в системе
     * @return - карточка юзера
     */
    UserDto getUser(UUID id);

    /**
     * обновление пользователя
     *
     * @param userDto - карточка юзера
     * @return - карточка юзера
     */
    UserDto updateUser(UserDto userDto);

    /**
     * удаление пользователя
     *
     * @param id - id юзера в системе
     */
    void deleteUser(UUID id);

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
