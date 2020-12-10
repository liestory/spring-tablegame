package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.CharacterDto;
import tablegame.dao.CharacterDAO;
import tablegame.model.Character;
import tablegame.model.CharacteristicsBase;

import java.util.UUID;

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
        Character character = new Character(characterDto.getId(),
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

}
