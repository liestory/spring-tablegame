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
import ru.tablegame.model.Game;
import ru.tablegame.repository.GameRepository;
import ru.tablegame.resource.dto.game.GameDto;
import ru.tablegame.service.GameServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.eq;
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
public class GameServiceTest {

    @Autowired
    GameServiceImpl gameService;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    MapperFacade mapperFacade;

    @Test
    public void create() {
        GameDto gameDto = new GameDto(1222372107439913231L, "Тест игра", null);
        Game game = new Game();

        when(mapperFacade.map(gameDto, eq(Game.class))).thenReturn(game);
        when(gameRepository.save(game)).thenReturn(game);
        when(mapperFacade.map(game, GameDto.class)).thenReturn(gameDto);

        GameDto gameDtoResult = gameService.regGame(gameDto);
        assertEquals(gameDto, gameDtoResult);

    }

    @Test
    void get() {
        GameDto gameDto = new GameDto(1222372107439913231L, "Тест игра", null);
        Long id = gameDto.getId();
        Game game = new Game();

        when(gameRepository.findById(id)).thenReturn(Optional.of(game));
        when(mapperFacade.map(game, GameDto.class)).thenReturn(gameDto);
        GameDto gameDtoResult = gameService.getGame(1222372107439913231L);

        assertEquals(gameDto, gameDtoResult);
        verify(gameRepository, times(1)).findById(id);
        verify(mapperFacade, atMost(1)).map(any(Game.class), eq(GameDto.class));
    }

    @Test
    void update() {
        GameDto gameDto = new GameDto(1222372107439913231L, "Тест игра", null);
        Game game = new Game();

        when(mapperFacade.map(game, GameDto.class)).thenReturn(gameDto);
        when(gameRepository.findById(anyLong())).thenReturn(Optional.of(game));
        when(gameRepository.save(game)).thenReturn(game);
        GameDto gameDtoResult = gameService.updateGame(gameDto);

        assertEquals(gameDto, gameDtoResult);
        verify(gameRepository, times(1)).findById(gameDto.getId());
        verify(gameRepository, times(1)).save(any(Game.class));
        verify(mapperFacade, times(1)).map(any(Game.class), eq(GameDto.class));
    }

    @Test
    void delete() {
        Long id = 1222372107439913231L;
        gameService.deleteGame(id);
        verify(gameService, times(1)).deleteGame(anyLong());
    }

    @Test
    public void findByNullId() {
        Long id = null;
        assertThrows(IllegalArgumentException.class, () -> gameService.getGame(id));
    }

    @Test
    public void findByIdButNotFound() {
        Long id = new Random().nextLong();
        when(gameRepository.findById(any(Long.class))).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> gameService.getGame(id));
    }
}
