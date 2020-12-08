package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.dao.GameDAO;
import tablegame.model.Game;

/**
 * @author nemykin 29.10.2020
 */
@Slf4j
@Service
public class CreateGameServiceImpl implements CreateGameService {

    private GameDAO gameDAO;

    public CreateGameServiceImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public GameDto regGame(UserDto userDto, GameDto gameDto) {
        Game game = new Game(gameDto.getId(), gameDto.getGameName());
        gameDAO.save(game);
        gameDto.setId(game.getId());
        //TODO: надо продумать как верно сделать выставления админом того, кто регистрирует игру
        //userDto.getUsername();
        return gameDto;
    }
}
