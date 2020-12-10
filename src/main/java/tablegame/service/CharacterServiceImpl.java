package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.CharacterDto;
import tablegame.dao.CharacterDAO;

/**
 * @author nemykin 08.12.2020
 */
@Slf4j
@Service
public class CharacterServiceImpl implements CharacterService {

    CharacterDAO characterDAO;

    public CharacterServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @Override
    public CharacterDto createCharacter(CharacterDto characterDto) {
        return null;
    }
}
