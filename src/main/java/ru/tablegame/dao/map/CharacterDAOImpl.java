package ru.tablegame.dao.map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.tablegame.dao.CharacterDAO;
import ru.tablegame.dao.mapper.CharacterMapper;
import ru.tablegame.model.Character;
import ru.tablegame.model.CharacterStatus;
import ru.tablegame.model.Characteristics;
import ru.tablegame.model.CharacteristicsBase;
import ru.tablegame.model.Inventory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author nemykin 07.12.2020
 */
@Repository
@Slf4j
public class CharacterDAOImpl implements CharacterDAO {

    public static final String SELECT_CHARACTER_BY_ID = "SELECT * FROM character WHERE id = ?";
    public static final String DELETE_FROM_CHARACTER = "DELETE FROM character WHERE id = ?";
    public static final String UPDATE_CHARACTER = "UPDATE character SET charactername = ? where id = ?";
    public static final String SELECT_ALL_CHARACTER = "SELECT * FROM character";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public CharacterDAOImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("character");
    }

    @Override
    public Character getCharacterByName(String characterName) {
        return null;
    }

    @Override
    public CharacterStatus getCharacterStatusByName(String characterName) {
        return null;
    }

    @Override
    public Characteristics getCharacterCharacteristicsByName(String characterName) {
        return null;
    }

    @Override
    public CharacteristicsBase getCharacterCharacteristicsBaseByName(String characterName) {
        return null;
    }

    @Override
    public Inventory getCharacterInventoryByName(String characterName) {
        return null;
    }

    @Override
    public Integer getCharacterLevelByName(String characterName) {
        return null;
    }

    @Override
    public Character save(Character ob) {
        ob.setId(new Random().nextLong());
        int result = addCharacterUsingSimpleJdbcInsert(ob);
        log.info("add " + result);
        return ob;
    }

    public int addCharacterUsingSimpleJdbcInsert(final Character character) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", character.getId());
        parameters.put("charactername", character.getCharacterName());
        parameters.put("character_status", character.getCharacterStatus());
        parameters.put("level", character.getLevel());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public Character getByPK(Long key) {
        return jdbcTemplate.queryForObject(SELECT_CHARACTER_BY_ID, new Object[]{key}, new CharacterMapper());
    }

    @Override
    public int deleteByPK(Long key) {
        return jdbcTemplate.update(DELETE_FROM_CHARACTER, key);
    }

    @Override
    public int update(Character ob) {
        return jdbcTemplate.update(UPDATE_CHARACTER, ob.getCharacterName(), ob.getId());
    }

    @Override
    public Character delete(Character ob) {
        return null;
    }

    @Override
    public Collection<Character> getAll() {
        return jdbcTemplate.query(SELECT_ALL_CHARACTER, new CharacterMapper());
    }

    @Override
    public Collection<Character> addAll(Collection<Character> obs) {
        return null;
    }
}
