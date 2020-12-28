package ru.tablegame.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tablegame.model.Character;
import ru.tablegame.model.CharacterStatus;
import ru.tablegame.model.Game;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB маппер для карточки персонажа
 *
 * @author nemykin 29.12.2020
 */
public class CharacterMapper implements RowMapper<Character> {
    @Override
    public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Character character = new Character();
        character.setId(Long.parseLong(rs.getString("id")));
        character.setCharacterName(rs.getString("charactername"));
        character.setCharacterStatus(CharacterStatus.valueOf(rs.getString("character_status")));
        character.setLevel(Integer.parseInt(rs.getString("level")));
        character.setGame(new Game(Long.parseLong(rs.getString("game_id"))));
        return character;
    }
}
