package ru.tablegame.service;

import ru.tablegame.controller.dto.GameDto;
import ru.tablegame.model.GameStatus;
import ru.tablegame.model.User;

import java.util.List;
import java.util.UUID;

/**
 * сервисы по состояниям игр
 *
 * @author Asus 14.10.2020
 */
public interface GameService {

    /**
     * создание игры
     *
     * @param gameDto - карта данных от клиента
     * @return - заполненая карта после создания
     */
    GameDto regGame(GameDto gameDto);

    /**
     * поиск игры
     *
     * @param id - id игры в системе
     * @return - карточка игры
     */
    GameDto getUser(Long id);

    /**
     * обновление пользователя
     *
     * @param gameDto - карточка игры
     */
    void updateUser(GameDto gameDto);

    /**
     * удаление игры
     *
     * @param id - id игры в системе
     */
    void deleteUser(Long id);

    /**
     * обновить статус игры
     *
     * @param game       - название игры
     * @param gameStatus - требуемый статус
     * @return - успешно ли выполнилась операция
     */
    boolean changeStatusInTheGame(String game, GameStatus gameStatus);

    /**
     * добавить игру
     *
     * @param game  - название игры
     * @param users - пользователи для новой игры
     */
    void addUserToGame(String game, List<User> users);

    /**
     * обновление списка пользователей
     *
     * @param game  - название игры
     * @param users - список пользователей
     * @return - возват карточки игры для клиента
     */
    GameDto updateUserToGame(String game, List<User> users);

    /**
     * удалить пользователей из игры по названию
     *
     * @param game  - название игры
     * @param users - список пользователей
     */
    void deleteUserToGame(String game, List<User> users);
}
