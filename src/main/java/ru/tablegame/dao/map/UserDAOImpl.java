package ru.tablegame.dao.map;

import org.springframework.stereotype.Repository;
import ru.tablegame.dao.UserDAO;
import ru.tablegame.model.Character;
import ru.tablegame.model.User;
import ru.tablegame.model.UserRoleAndStatus;

import java.util.HashMap;
import java.util.List;
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
    public List<UserRoleAndStatus> getRoleByLogin(String name) {
        for (User element : elements.values()) {
            if (element.getUsername().equals(name)) {
                return element.getUserRoleAndStatusList();
            }
        }
        return null;
    }

    @Override
    public List<Character> getCharacterByLogin(String name) {
        for (User element : elements.values()) {
            if (element.getUsername().equals(name)) {
                return element.getCharacterList();
            }
        }
        return null;
    }

    @Override
    public List<Character> getCharacterByUserIdAndGameName(UUID userId) {
        for (User element : elements.values()) {
            if (element.getId().equals(userId)) {
                return element.getCharacterList();
            }
        }
        return null;
    }

}
