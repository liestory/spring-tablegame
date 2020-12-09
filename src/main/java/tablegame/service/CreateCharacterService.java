package tablegame.service;

import tablegame.controller.dto.CharacterDto;

/**
 * @author nemykin 08.12.2020
 */
public interface CreateCharacterService {

    /**
     *  создания персонажа с
     * @param characterDto
     * @return
     */
    CharacterDto createCharacter(CharacterDto characterDto);

}
