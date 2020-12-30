package ru.tablegame.dao.map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.tablegame.dao.UserDAO;
import ru.tablegame.dao.mapper.UserMapper;
import ru.tablegame.model.Character;
import ru.tablegame.model.User;
import ru.tablegame.model.UserRoleAndStatus;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Asus 14.10.2020
 */
@Repository
@Slf4j
public class UserDAOImpl implements UserDAO {

    public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String DELETE_FROM_USER = "DELETE FROM user WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE user SET username = ? where id = ?";
    public static final String SELECT_ALL_USER = "SELECT * FROM user";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public UserDAOImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("user");
    }

    @Override
    public User findPlayerByLogin(String name) {
        return null;
    }

    @Override
    public List<UserRoleAndStatus> getRoleByLogin(String name) {
        return null;
    }

    @Override
    public List<Character> getCharacterByLogin(String name) {
        return null;
    }

    @Override
    public List<Character> getCharacterByUserIdAndGameName(UUID userId) {
        return null;
    }

    @Override
    public User save(User user) {
        user.setId(UUID.randomUUID());
        int result = addUserUsingSimpleJdbcInsert(user);
        log.info("add " + result);
        return user;
    }

    public int addUserUsingSimpleJdbcInsert(final User user) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", user.getId());
        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public User getByPK(UUID key) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new Object[]{key}, new UserMapper());
    }

    @Override
    public int deleteByPK(UUID key) {
        return jdbcTemplate.update(DELETE_FROM_USER, key);
    }

    @Override
    public int update(User ob) {
        return jdbcTemplate.update(UPDATE_USER, ob.getUsername(), ob.getId());
    }

    @Override
    public User delete(User ob) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return jdbcTemplate.query(SELECT_ALL_USER, new UserMapper());
    }

    @Override
    public Collection<User> addAll(Collection<User> obs) {
        return null;
    }
}
