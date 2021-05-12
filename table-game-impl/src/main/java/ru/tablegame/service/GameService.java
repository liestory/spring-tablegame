package ru.tablegame.service;

import org.springframework.security.access.prepost.PreAuthorize;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.resource.dto.PageDto;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.game.GameDto;
import ru.tablegame.resource.dto.game.GameSearchDto;

import java.util.UUID;

/**
 * сервисы по работе с играми
 *
 * @author Asus 14.10.2020
 */
public interface GameService {

    /**
     * создание игры
     *
     * @param gameDto - карта данных от клиента
     * @return - заполненая карта после создания
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Mono<GameDto> regGame(GameDto gameDto);

    /**
     * поиск игры
     *
     * @param id - id игры в системе
     * @return - карточка игры
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Mono<GameDto> getGame(UUID id);

    /**
     * обновление пользователя
     *
     * @param gameDto - карточка игры
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT')")
    Mono<GameDto> updateGame(GameDto gameDto);

    /**
     * удаление игры
     *
     * @param id - id игры в системе
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT')")
    Mono<Void> deleteGame(UUID id);

    /**
     * пагинационный поиск игр
     *
     * @param gameSearchDto - карточки игр для поиска
     * @return - пацинационный список игр
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Flux<GameDto> getGames(Search<GameSearchDto> gameSearchDto);
}
