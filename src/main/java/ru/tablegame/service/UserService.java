package ru.tablegame.service;

import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;

import java.util.List;
import java.util.UUID;

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
     * получения карточки персонажа по id юзеру и названию игры
     *
     * @param userId   - id юзера
     * @param gameName - название игры
     * @return -  список карточек персонажа
     */
    List<CharacterDto> getCharacterByUserIdAndGameName(UUID userId, String gameName);
}
