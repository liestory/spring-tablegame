package ru.tablegame.dao.map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.tablegame.dao.GameDAO;
import ru.tablegame.dao.mapper.GameMapper;
import ru.tablegame.model.Game;
import ru.tablegame.model.User;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Asus 14.10.2020
 */
@Repository
@Slf4j
public class GameDAOImpl implements GameDAO {

    public static final String SELECT_GAME_BY_ID = "SELECT * FROM game WHERE id = ?";
    public static final String DELETE_FROM_GAME = "DELETE FROM game WHERE id = ?";
    public static final String UPDATE_GAME = "UPDATE game SET game_name = ? where id = ?";
    public static final String SELECT_ALL_GAME = "SELECT * FROM game";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public GameDAOImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("game");
    }

    @Override
    public Game getByName(String gameName) {
        return null;
    }

    @Override
    public void addUserForGame(String gameName, List<User> user) {
    }

    @Override
    public void deleteUserForGame(String gameName, List<User> user) {
    }

    @Override
    public Game save(Game ob) {
        ob.setId(new Random().nextLong());
        int result = addGameUsingSimpleJdbcInsert(ob);
        log.info("add " + result);
        return ob;
    }

    public int addGameUsingSimpleJdbcInsert(final Game game) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", game.getId());
        parameters.put("game_name", game.getGameName());
        parameters.put("game_status", game.getGameStatus());
        parameters.put("game_at", new Date());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public Game getByPK(Long key) {
        return jdbcTemplate.queryForObject(SELECT_GAME_BY_ID, new Object[]{key}, new GameMapper());
    }

    @Override
    public int deleteByPK(Long key) {
        return jdbcTemplate.update(DELETE_FROM_GAME, key);
    }

    @Override
    public int update(Game ob) {
        return jdbcTemplate.update(UPDATE_GAME, ob.getGameName(), ob.getId());
    }

    @Override
    public Game delete(Game ob) {
        return null;
    }

    @Override
    public Collection<Game> getAll() {
        return jdbcTemplate.query(SELECT_ALL_GAME, new GameMapper());
    }

    @Override
    public Collection<Game> addAll(Collection<Game> obs) {
        return null;
    }
}
