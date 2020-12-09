package tablegame.service;

import tablegame.model.Game;
import tablegame.model.GameStatus;
import tablegame.model.User;

import java.util.List;

/**
 *  сервисы по состояниям игр
 *
 * @author Asus 14.10.2020
 */
public interface GameService {
    /**
     * добавить игру
     *
     * @param game
     * @param users
     */
    void addUserToGame(String game, List<User> users);

    /**
     *
     * @param game
     * @param gameStatus
     * @return
     */
    boolean changeStatusInTheGame(Game game, GameStatus gameStatus);

}
