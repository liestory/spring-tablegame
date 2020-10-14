package tablegame.dao;

import tablegame.model.Game;

/**
 * @author Asus 14.10.2020
 */
public interface GameDAO extends GenericDAO<Game, Long>{

    /**
     *
     * @param gameName
     * @return
     */
    Game getByName(String gameName);

}
