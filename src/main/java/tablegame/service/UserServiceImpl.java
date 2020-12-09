package tablegame.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import tablegame.dao.UserDAO;
import tablegame.model.Character;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;
import tablegame.model.UserStatus;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Asus 14.10.2020
 */
@Service
@PropertySource(value = {"classpath:application.properties"})
public class UserServiceImpl implements UserService {

    private static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        log.info("create user service");
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public void addUser(User user) {
        log.info("now: " + LocalDateTime.now() + " UserService: " + this.toString());
        userDAO.save(user);
    }

    @Override
    public void addRole(User user, Role role, Game game) {
        user.getRole().put(game, role);
    }

    @Override
    public void changeRole(User user, Role role, Game game) {
        for (Map.Entry<Game, Role> gameRoleEntry : user.getRole().entrySet()) {
            if (gameRoleEntry.getKey().equals(game.getGameName())) {
                gameRoleEntry.setValue(role);
            }
        }

    }

    @Override
    public void changeStatus(User user, UserStatus status) {
        user.setUserStatus(status);
    }

    @Override
    public void createCharacterByUser(User user, Game game) {
        Character character = new Character();
        user.getCharacterGameMap().put(game, character);
    }
}
