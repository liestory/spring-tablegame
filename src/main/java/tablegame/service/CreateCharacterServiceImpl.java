package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.CharacterDto;
import tablegame.dao.CharacterDAO;
import tablegame.model.Character;

/**
 * @author nemykin 08.12.2020
 */
@Slf4j
@Service
public class CreateCharacterServiceImpl implements CreateCharacterService {

    CharacterDAO characterDAO;

    @Override
    public Character createCharacter(CharacterDto characterDto) {
        return null;
    }
}
