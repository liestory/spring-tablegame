package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.CharacterDto;
import tablegame.dao.CharacterDAO;
import tablegame.model.Character;
import tablegame.model.CharacterStatus;
import tablegame.model.CharacteristicsBase;

import java.util.Random;

/**
 * @author nemykin 08.12.2020
 */
@Slf4j
@Service
@PropertySource(value = {"classpath:application.properties"})
public class CharacterServiceImpl implements CharacterService {

    @Value("${character.level.min}")
    private String minLevel;
    CharacterDAO characterDAO;

    public CharacterServiceImpl(CharacterDAO characterDAO) {
        log.info("create character service");
        this.characterDAO = characterDAO;
    }

    @Override
    public CharacterDto createCharacter(CharacterDto characterDto) {
        if (characterDto.getLevel() <= Integer.valueOf(minLevel)) {
            throw new RuntimeException("При создании уровень персонажа не меньше " + minLevel);
        }
        Character character = new Character(new Random().nextLong(),
                characterDto.getCharacterName(),
                characterDto.getLevel(),
                new CharacteristicsBase(characterDto.getCharacteristicsDto().getStrength(),
                        characterDto.getCharacteristicsDto().getDexterity(),
                        characterDto.getCharacteristicsDto().getConstitution(),
                        characterDto.getCharacteristicsDto().getIntelligent(),
                        characterDto.getCharacteristicsDto().getWisdom(),
                        characterDto.getCharacteristicsDto().getCharisma()));
        characterDAO.save(character);
        characterDto.setId(character.getId());
        return characterDto;
    }

    @Override
    public void killCharacter(CharacterDto characterDto) {
        characterDAO.getCharacterByName(characterDto.getCharacterName()).setCharacterStatus(CharacterStatus.DEAD);
    }

}
