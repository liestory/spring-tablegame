package tablegame.dao;

import tablegame.model.Game;
import tablegame.model.User;

import java.util.List;

/**
 * методы работ с играми
 *
 * @author Asus 14.10.2020
 */
public interface GameDAO extends GenericDAO<Game, Long> {

    /**
     * получить игру по названию
     *
     * @param gameName - название игры
     * @return - карточка игры
     */
    Game getByName(String gameName);

    /**
     * Добавить юзеров в игру
     *
     * @param gameName - название игры
     * @param user     - списоку юзеров
     */
    void addUserForGame(String gameName, List<User> user);


//    GameStatus get
}
