package ru.tablegame.dao;

import ru.tablegame.model.Character;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;
import ru.tablegame.model.UserRoleAndStatus;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * методы работ с юзером
 *
 * @author nemykin 14.10.2020
 */
public interface UserDAO extends GenericDAO<User, UUID> {

    /**
     * Получить данные по юзер по логину
     *
     * @param name - логин пользователя
     * @return - карточка юзера
     */
    User findPlayerByLogin(String name);

    /**
     * Получить роли и статус у данного юзера по логину.
     *
     * @param name     - логин пользователя
     * @return - карточки состояния юзера
     */
    List<UserRoleAndStatus> getRoleByLogin(String name);

    /**
     * получить всех персонажа по его логину
     *
     * @param name -  логин пользователя
     * @return -  список карточек персонажа
     */
    List<Character> getCharacterByLogin(String name);

    /**
     * получить список персонажей по его
     *
     * @param userId   - id юзера в системе
     * @return - список карточек персонажа
     */
    List<Character> getCharacterByUserIdAndGameName(UUID userId);


}
