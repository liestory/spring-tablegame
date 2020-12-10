package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.CharacteristicsDto;
import tablegame.dao.CharacterDAO;
import tablegame.model.Characteristics;

/**
 * @author nemykin 10.12.2020
 */
@Slf4j
@Service
public class CharacteristicsServiceImpl implements CharacteristicsService {
    private CharacterDAO characterDAO;

    public CharacteristicsServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @Override
    public void addCharacterCharacteristics(String characterName, CharacteristicsDto characteristicsDto) {
        Characteristics characteristics = characterDAO.getCharacterCharacteristicsByName(characterName);
        characteristics.setStrength(characteristicsDto.getStrength());
        characteristics.setDexterity(characteristicsDto.getDexterity());
        characteristics.setConstitution(characteristicsDto.getConstitution());
        characteristics.setIntelligent(characteristicsDto.getIntelligent());
        characteristics.setWisdom(characteristicsDto.getWisdom());
        characteristics.setCharisma(characteristicsDto.getCharisma());
    }

    @Override
    public CharacteristicsDto updateCharacterCharacteristics(String characterName, CharacteristicsDto characteristicsDto) {
        Characteristics characteristics = characterDAO.getCharacterCharacteristicsByName(characterName);
        characteristics.setStrength(characteristicsDto.getStrength());
        characteristics.setDexterity(characteristicsDto.getDexterity());
        characteristics.setConstitution(characteristicsDto.getConstitution());
        characteristics.setIntelligent(characteristicsDto.getIntelligent());
        characteristics.setWisdom(characteristicsDto.getWisdom());
        characteristics.setCharisma(characteristicsDto.getCharisma());
        return characteristicsDto;
    }

    @Override
    public void deleteCharacterCharacteristics(String characterName) {
        Characteristics characteristics = characterDAO.getCharacterCharacteristicsByName(characterName);
        characteristics.setStrength(0);
        characteristics.setDexterity(0);
        characteristics.setConstitution(0);
        characteristics.setIntelligent(0);
        characteristics.setWisdom(0);
        characteristics.setCharisma(0);
    }
}
