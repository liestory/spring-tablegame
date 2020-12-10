package tablegame.service;

import tablegame.controller.dto.GameDto;
import tablegame.model.GameStatus;
import tablegame.model.User;

import java.util.List;

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
