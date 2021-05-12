package ru.tablegame;

import ma.glasnost.orika.MapperFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.tablegame.model.Character;
import ru.tablegame.model.Game;
import ru.tablegame.repository.CharacterRepository;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.service.CharacterServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author nemykin 22.03.2021
 */
@ExtendWith({MockitoExtension.class, SpringExtension.class})
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CharacterServiceTest {

    @Autowired
    CharacterServiceImpl characterService;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    MapperFacade mapperFacade;

    @Test
    public void create() {
        CharacterDto characterDto = new CharacterDto(1222372107439913231L,
                "Тест игрок", "Тест персонаж",
                null,
                null,
                1,
                null,
                "Тестовая игра",
                "Создан");
        Character character = new Character();

        when(mapperFacade.map(characterDto, eq(Character.class))).thenReturn(character);
        when(characterRepository.save(character)).thenReturn(character);
        when(mapperFacade.map(character, CharacterDto.class)).thenReturn(characterDto);

        CharacterDto characterDtoResult = characterService.createCharacter(characterDto);
        assertEquals(characterDto, characterDtoResult);

    }

    @Test
    void get() {
        CharacterDto characterDto = new CharacterDto(1222372107439913231L,
                "Тест игрок", "Тест персонаж",
                null,
                null,
                1,
                null,
                "Тестовая игра",
                "Создан");
        Long id = characterDto.getId();
        Character character = new Character();

        when(characterRepository.findById(id)).thenReturn(Optional.of(character));
        when(mapperFacade.map(character, CharacterDto.class)).thenReturn(characterDto);
        CharacterDto characterDtoResult = characterService.getCharacter(1222372107439913231L);

        assertEquals(characterDto, characterDtoResult);
        verify(characterRepository, times(1)).findById(id);
        verify(mapperFacade, atMost(1)).map(any(Game.class), eq(CharacterDto.class));
    }

    @Test
    void update() {
        CharacterDto characterDto = new CharacterDto(1222372107439913231L,
                "Тест игрок", "Тест персонаж",
                null,
                null,
                1,
                null,
                "Тестовая игра",
                "Создан");
        Character character = new Character();

        when(mapperFacade.map(character, CharacterDto.class)).thenReturn(characterDto);
        when(characterRepository.findById(anyLong())).thenReturn(Optional.of(character));
        when(characterRepository.save(character)).thenReturn(character);
        CharacterDto characterDtoResult = characterService.updateCharacter(characterDto);

        assertEquals(characterDto, characterDtoResult);
        verify(characterRepository, times(1)).findById(characterDto.getId());
        verify(characterRepository, times(1)).save(any(Character.class));
        verify(mapperFacade, times(1)).map(any(Character.class), eq(CharacterDto.class));
    }

    @Test
    void kill() {
        Long id = 1222372107439913231L;
        characterService.killCharacter(id);
        verify(characterService, times(1)).killCharacter(anyLong());
    }

    @Test
    void delete() {
        Long id = 1222372107439913231L;
        characterService.deleteCharacter(id);
        verify(characterService, times(1)).deleteCharacter(anyLong());
    }

    @Test
    public void findByNullId() {
        Long id = null;
        assertThrows(IllegalArgumentException.class, () -> characterService.getCharacter(id));
    }

    @Test
    public void findByIdButNotFound() {
        Long id = new Random().nextLong();
        when(characterRepository.findById(any(Long.class))).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> characterService.getCharacter(id));
    }
}
