package tablegame.service;

import org.springframework.stereotype.Service;
import tablegame.controller.dto.GameDto;
import tablegame.dao.GameDAO;
import tablegame.model.Game;

/**
 * @author nemykin 29.10.2020
 */
@Service
public class CreateGameServiceImpl implements CreateGameService {

    private GameDAO gameDAO;

    public CreateGameServiceImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public GameDto regGame(GameDto gameDto) {
        Game game = new Game(gameDto.getId(), gameDto.getGameName());
        gameDAO.save(game);
        gameDto.setId(game.getId());
        return gameDto;
    }
}
