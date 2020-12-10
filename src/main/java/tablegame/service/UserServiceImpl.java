package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.dao.UserDAO;
import tablegame.model.Character;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * @author Asus 14.10.2020
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

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
    public Map<Game, Character> getCharacterByUserIdAndGameName(UUID userId, String gameName) {
        return userDAO.getCharacterByUserIdAndGameName(userId, gameName);
    }

}
