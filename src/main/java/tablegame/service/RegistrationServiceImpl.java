package tablegame.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.dao.GameDAO;
import tablegame.dao.UserDAO;
import tablegame.model.Game;
import tablegame.model.User;

import java.util.UUID;

/**
 * @author Asus 28.10.2020
 */
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class.getName());
    private UserDAO userDao;
    private GameDAO gameDAO;

    public RegistrationServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    public RegistrationServiceImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword());
        userDao.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public GameDto regGame(GameDto gameDto) {
        Game game = new Game(gameDto.getId(), gameDto.getGameName());
        gameDAO.save(game);
        gameDto.setId(game.getId());
        return gameDto;
    }

}
