package ru.tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.dao.CharacterDAO;
import ru.tablegame.model.Character;
import ru.tablegame.model.CharacterStatus;

import java.util.Random;

/**
 * @author nemykin 08.12.2020
 */
@Slf4j
@Service
public class CharacterServiceImpl implements CharacterService {

    CharacterDAO characterDAO;

    public CharacterServiceImpl(CharacterDAO characterDAO) {
        log.info("create character service");
        this.characterDAO = characterDAO;
    }

    @Override
    public CharacterDto createCharacter(CharacterDto characterDto) {
        Character character = new Character();
        character.setId(new Random().nextLong());
        character.setCharacterName(characterDto.getCharacterName());
        character.setCharacteristics(characterDto.getCharacteristics());
        character.setCharacteristicsBase(characterDto.getCharacteristicsBase());
        character.setLevel(characterDto.getLevel());
        character.setInventory(characterDto.getInventory());
        characterDAO.save(character);
        characterDto.setId(character.getId());
        return characterDto;
    }

    @Override
    public CharacterDto getCharacter(Long id) {
        Character character = characterDAO.getByPK(id);
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(character.getId());
        characterDto.setCharacterName(character.getCharacterName());
        characterDto.setLevel(character.getLevel());
        return characterDto;
    }

    @Override
    public void updateCharacter(CharacterDto characterDto) {
        Character character = characterDAO.getByPK(characterDto.getId());
        character.setCharacterName(characterDto.getCharacterName());
        character.setCharacteristics(characterDto.getCharacteristics());
        character.setCharacteristicsBase(characterDto.getCharacteristicsBase());
        character.setLevel(characterDto.getLevel());
        character.setInventory(characterDto.getInventory());
        characterDAO.update(character);
    }

    @Override
    public void deleteCharacter(Long id) {
        characterDAO.deleteByPK(id);
    }

    @Override
    public void killCharacter(Long id) {
        characterDAO.getByPK(id).setCharacterStatus(CharacterStatus.DEAD);
    }

}
