package ru.tablegame.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.exception.GlobalExceptionHandler;
import ru.tablegame.model.Character;
import ru.tablegame.model.CharacterStatus;
import ru.tablegame.repository.CharacterRepository;
import ru.tablegame.repository.GameRepository;
import ru.tablegame.repository.UserRepository;
import ru.tablegame.resource.dto.PageDto;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.resource.dto.character.CharacterSearchDto;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * @author nemykin 08.12.2020
 */
@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository characterRepository;
    private GameRepository gameRepository;
    private final MapperFacade mapperFacade;

    @Override
    public Mono<CharacterDto> createCharacter(CharacterDto characterDto) {
        Character character = mapperFacade.map(characterDto, Character.class);
        //TODO: сюда надо значения из токена брать
        character.setUserId(null);
        character.setGame(gameRepository.findGameByGameName(characterDto.getGameName()));
        character.setId(randomUUID());
        return Mono.when((Iterable<? extends Publisher<?>>) characterRepository.save(character))
                .then(Mono.fromSupplier(() -> mapperFacade.map(character, CharacterDto.class)));
    }

    @Override
    public Mono<CharacterDto> getCharacter(UUID id) {
        return Mono.fromSupplier(() ->
                characterRepository.findById(id)
                        .map(characterDto -> mapperFacade.map(characterDto, CharacterDto.class))
                        .orElseThrow(() -> new IllegalArgumentException("character = " + id))
        );
    }

    @Override
    public Mono<CharacterDto> updateCharacter(CharacterDto characterDto) {
        Character character = characterRepository.getOne(characterDto.getId());
        character.setCharacterName(characterDto.getCharacterName());
        character.setCharacteristics(characterDto.getCharacteristics());
        character.setCharacteristicsBase(characterDto.getCharacteristicsBase());
        character.setLevel(characterDto.getLevel());
        character.setInventory(characterDto.getInventory());
        return Mono.when((Iterable<? extends Publisher<?>>) characterRepository.save(character))
                .then(Mono.fromSupplier(() -> mapperFacade.map(character, CharacterDto.class)));
    }

    @Override
    public Mono<Void> deleteCharacter(UUID id) {
        return Mono.fromRunnable(() -> characterRepository.deleteById(id));
    }

    @Override
    public Mono<Void> killCharacter(UUID id) {
        return Mono.fromRunnable(() -> characterRepository.getOne(id).setCharacterStatus(CharacterStatus.DEAD));
    }

    @Override
    public Mono<Void> changeStatusCharacter(UUID id, CharacterDto characterDto) {
        return Mono.fromRunnable(() -> characterRepository.getOne(id)
                .setCharacterStatus(CharacterStatus.getStatusByDesc(characterDto.getStatusDesc())));
    }

    @Override
    public Flux<CharacterDto> getCharacters(Search<CharacterSearchDto> characterSearchDto) {
        return Flux.fromIterable(characterRepository.findAll(getSpec(characterSearchDto.getData()), getOf(characterSearchDto)))
                .map(characterSearch -> mapperFacade.map(characterSearch, CharacterDto.class));

    }

    private PageRequest getOf(Search<CharacterSearchDto> characterSearchDto) {
        var page = characterSearchDto.getPage();
        return PageRequest.of(page.getPage(), page.getSize());
    }

    private Specification<Character> getSpec(CharacterSearchDto characterSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (characterSearchDto.getCharacterName() != null) {
                predicates.add(root.get("charactername").in(characterSearchDto.getGameName()));
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }

    @Override
    public List<CharacterDto> getAllCharacters() {
        return mapperFacade.mapAsList(characterRepository.findAll(), CharacterDto.class);
    }
}
