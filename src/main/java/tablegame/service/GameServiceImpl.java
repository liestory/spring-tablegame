package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.GameDto;
import tablegame.dao.GameDAO;
import tablegame.model.Game;
import tablegame.model.GameStatus;
import tablegame.model.User;

import java.util.List;
import java.util.Random;

/**
 * @author Asus 14.10.2020
 */
@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private GameDAO gameDAO;

    public GameServiceImpl(GameDAO gameDAO) {
        log.info("create game service");
        this.gameDAO = gameDAO;
    }

    @Override
    public GameDto regGame(GameDto gameDto) {
        Game game = new Game(new Random().nextLong(), gameDto.getGameName());
        gameDAO.save(game);
        gameDto.setId(game.getId());
        return gameDto;
    }

    @Override
    public boolean changeStatusInTheGame(String game, GameStatus gameStatus) {
        GameStatus gameStatusBefore = gameDAO.getByName(game).getGameStatus();
        gameDAO.getByName(game).setGameStatus(gameStatus);
        if (!gameStatusBefore.equals(gameStatus)) {
            return true;
        }
        return false;
    }

    @Override
    public void addUserToGame(String game, List<User> users) {
        gameDAO.addUserForGame(game, users);

    }

    @Override
    public GameDto updateUserToGame(String game, List<User> users) {
        gameDAO.addUserForGame(game, users);
        Game gameClass = gameDAO.getByName(game);
        GameDto gameDto = new GameDto(gameClass.getId(),
                gameClass.getGameName(),
                gameClass.getUsers());
        return gameDto;
    }

    @Override
    public void deleteUserToGame(String game, List<User> users) {
        gameDAO.deleteUserForGame(game, users);
    }
}
