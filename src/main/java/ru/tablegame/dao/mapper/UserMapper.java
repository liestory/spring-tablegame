package ru.tablegame.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tablegame.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * DB маппер для карточки игрока
 *
 * @author nemykin 29.12.2020
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        final User user = new User();
        user.setId(UUID.fromString(rs.getString("id")));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
