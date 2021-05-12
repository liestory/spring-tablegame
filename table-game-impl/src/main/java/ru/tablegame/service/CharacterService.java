package ru.tablegame.service;

import org.springframework.security.access.prepost.PreAuthorize;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.resource.dto.PageDto;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.resource.dto.character.CharacterSearchDto;

import java.util.List;
import java.util.UUID;

/**
 * сервис по работе с персонажами
 *
 * @author nemykin 08.12.2020
 */
public interface CharacterService {

    /**
     * создания персонажа
     *
     * @param characterDto - карточка персонажа от клиента
     * @return - обновленная карточка для клиента
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Mono<CharacterDto> createCharacter(CharacterDto characterDto);

    /**
     * создания персонажа
     *
     * @param id - id персонажа
     * @return - обновленная карточка для клиента
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Mono<CharacterDto> getCharacter(UUID id);

    /**
     * персонажа
     *
     * @param characterDto - карточка персонажа
     * @return - обновленная карточка для клиента
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Mono<CharacterDto> updateCharacter(CharacterDto characterDto);

    /**
     * удаление персонажа
     * TODO: для логики CRUD присутсвует, но по логике персонажи никогда не должны исчезнуть
     *
     * @param id - id персонажа
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    Mono<Void> deleteCharacter(UUID id);

    /**
     * убийство персонажа (перевод в статус смерть)
     *
     * @param id - id карточки персонажа
     */
    Mono<Void> killCharacter(UUID id);

    /**
     * изменения статуса персонажа (перевод в статус смерть)
     *
     * @param id           - id карточки персонажа
     * @param characterDto - карточка персонажа
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT')")
    Mono<Void> changeStatusCharacter(UUID id, CharacterDto characterDto);

    /**
     * пагинационный поиск персонажей
     *
     * @param characterSearchDto -карточки персонажей для поиска
     * @return - пацинационный список персонажей
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Flux<CharacterDto> getCharacters(Search<CharacterSearchDto> characterSearchDto);

    /**
     * получение всех персонажей
     *
     * @return - список персонажей
     */
    List<CharacterDto> getAllCharacters();
}