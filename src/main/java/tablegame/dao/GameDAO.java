package tablegame.dao;

import tablegame.model.Game;
import tablegame.model.GameStatus;
import tablegame.model.User;

import java.util.List;

/**
 * методы работ с играми
 *
 * @author Asus 14.10.2020
 */
public interface GameDAO extends GenericDAO<Game, Long> {

    /**
     * получить название игры
     *
     * @param gameName
     * @return
     */
    Game getByName(String gameName);

    /**
     * @param user
     */
    void addUserForGame(Game gameName, List<User> user);


//    GameStatus get
}
