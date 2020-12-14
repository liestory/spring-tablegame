package ru.tablegame.dao.map;

import org.springframework.stereotype.Repository;
import ru.tablegame.dao.UserDAO;
import ru.tablegame.model.Character;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;

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
    public Map<Game, Character> getCharacterByLogin(String name) {
        for (User element : elements.values()) {
            if (element.getUsername().equals(name)) {
                return element.getCharacterGameMap();
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

    @Override
    public Map<Game, Character> getCharacterByUserNameAndGameName(String userName, String gameName) {
        for (User element : elements.values()) {
            if (element.getUsername().equals(userName)) {
                for (Map.Entry<Game, Character> gameCharacterEntry : element.getCharacterGameMap().entrySet())
                    if (gameCharacterEntry.getKey().getGameName().equals(gameName)) {
                        return Map.ofEntries(gameCharacterEntry);
                    }
            }
        }
        return null;
    }
}
