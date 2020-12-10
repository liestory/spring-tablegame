package tablegame.dao.map;

import org.springframework.stereotype.Repository;
import tablegame.dao.UserDAO;
import tablegame.model.Character;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Asus 14.10.2020
 */
@Repository
public class UserDAOImpl extends AbstractDao<User, UUID> implements UserDAO {
    public UserDAOImpl() {
        super(User.class, new HashMap<>());
    }

    @Override
    public User findPlayerByLogin(String name) {
        for (User element : elements.values()) {
            if (element.getUsername().equals(name)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public Role getRoleByLogin(String name, String gameName) {
        for (User element : elements.values()) {
            if (element.getUsername().equals(name)) {
                for (Map.Entry<Game, Role> roleGameEntry : element.getRole().entrySet())
                    if (roleGameEntry.getKey().getGameName().equals(gameName)) {
                        return roleGameEntry.getValue();
                    }
            }
        }
        return null;
    }

    @Override
    public Map<Game, Character> getCharacterByUserIdAndGameName(UUID userId, String gameName) {
        for (User element : elements.values()) {
            if (element.getId().equals(userId)) {
                for (Map.Entry<Game, Character> gameCharacterEntry : element.getCharacterGameMap().entrySet())
                    if (gameCharacterEntry.getKey().getGameName().equals(gameName)) {
                        return Map.ofEntries(gameCharacterEntry);
                    }
            }
        }
        return null;
    }
}
