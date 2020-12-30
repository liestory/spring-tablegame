package ru.tablegame.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tablegame.model.Game;
import ru.tablegame.model.GameStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB маппер для карточки игры
 *
 * @author nemykin 29.12.2020
 */
public class GameMapper implements RowMapper<Game> {
    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Game game = new Game();
        game.setId(Long.parseLong(rs.getString("id")));
        game.setGameName(rs.getString("game_name"));
        game.setGameStatus(GameStatus.valueOf(rs.getString("game_status")));
        return game;
    }
}
