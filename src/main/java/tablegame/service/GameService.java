package tablegame.service;

import tablegame.model.Game;

/**
 * @author Asus 14.10.2020
 */
public interface GameService {
    /**
     * добавить игру
     *
     * @param game
     */
    void addGame(Game game);
}
