package tablegame.service;

import tablegame.controller.dto.CharacterDto;
import tablegame.model.Character;

/**
 * @author nemykin 08.12.2020
 */
public interface CreateCharacterService {

    /**
     *
     * @param userName
     * @param characterName
     * @return
     */
    Character createCharacter(CharacterDto characterDto);


}
