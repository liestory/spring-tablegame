package tablegame.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import tablegame.dao.GameDAO;
import tablegame.model.Game;
import tablegame.model.GameStatus;
import tablegame.model.User;

import java.util.List;

/**
 * @author Asus 14.10.2020
 */
@Service
@PropertySource(value = {"classpath:application.properties"})
public class GameServiceImpl implements GameService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    private GameDAO gameDAO;

    public GameServiceImpl(GameDAO gameDAO) {
        log.info("create game service");
        this.gameDAO = gameDAO;
    }

    @Override
    public void addUserToGame(Game game, List<User> users) {
        gameDAO.addUserForGame(game, users);
    }

    @Override
    public boolean changeStatusInTheGame(Game game, GameStatus gameStatus) {
        GameStatus gameStatusBefore = game.getGameStatus();
        game.setGameStatus(gameStatus);
        if (!gameStatusBefore.equals(gameStatus)) {
            return true;
        }
        return false;
    }
}
