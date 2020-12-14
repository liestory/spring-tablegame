package ru.tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tablegame.controller.dto.GameDto;
import ru.tablegame.dao.GameDAO;
import ru.tablegame.model.Game;
import ru.tablegame.model.GameStatus;
import ru.tablegame.model.User;

import java.util.List;

/**
 * @author Asus 14.10.2020
 */
@Service
@Slf4j
public class GameServiceImpl implements GameService {

    private GameDAO gameDAO;

    public GameServiceImpl(GameDAO gameDAO) {
        log.info("create game service");
        this.gameDAO = gameDAO;
    }

    @Override
    public GameDto regGame(GameDto gameDto) {
        Game game = new Game(gameDto.getId(), gameDto.getGameName());
        gameDAO.save(game);
        gameDto.setId(game.getId());
        return gameDto;
    }

    @Override
    public GameDto getUser(Long id) {
        Game game = gameDAO.getByPK(id);
        GameDto gameDto = new GameDto();
        gameDto.setId(game.getId());
        gameDto.setGameName(game.getGameName());
        gameDto.getUserNameList().addAll(game.getUsers());
        return gameDto;
    }

    @Override
    public void updateUser(GameDto gameDto) {
        Game game = gameDAO.getByPK(gameDto.getId());
        game.setId(gameDto.getId());
        game.setGameName(gameDto.getGameName());
        game.getUsers().addAll(gameDto.getUserNameList());
    }

    @Override
    public void deleteUser(Long id) {
        gameDAO.deleteByPK(id);
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
        GameDto gameDto = new GameDto();
        gameDto.setId(gameClass.getId());
        gameDto.setGameName(gameClass.getGameName());
        gameDto.getUserNameList().addAll(gameClass.getUsers());
        return gameDto;
    }

    @Override
    public void deleteUserToGame(String game, List<User> users) {
        gameDAO.deleteUserForGame(game, users);
    }
}
