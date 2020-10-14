package tablegame.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tablegame.dao.GameDAO;
import tablegame.dao.UserDAO;
import tablegame.model.Game;

/**
 * @author Asus 14.10.2020
 */
public class GameServiceImpl implements GameService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    private GameDAO gameDAO;

    public GameServiceImpl(GameDAO gameDAO) {
        log.info("create game service");
        this.gameDAO = gameDAO;
    }

    @Override
    public void addGame(Game game) {
        gameDAO.save(game);
    }
}
