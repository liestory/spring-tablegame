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
import ru.tablegame.model.Game;
import ru.tablegame.repository.GameRepository;
import ru.tablegame.resource.dto.PageDto;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.resource.dto.game.GameDto;
import ru.tablegame.resource.dto.game.GameSearchDto;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * @author Asus 14.10.2020
 */
@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private final MapperFacade mapperFacade;

    @Override
    public Mono<GameDto> regGame(GameDto gameDto) {
        Game game = new Game(randomUUID(), gameDto.getGameName());
        return Mono.when((Iterable<? extends Publisher<?>>) gameRepository.save(game))
                .then(Mono.fromSupplier(() -> mapperFacade.map(game, GameDto.class)));
    }

    @Override
    public Mono<GameDto> getGame(UUID id) {
        return Mono.fromSupplier(() ->
                gameRepository.findById(id)
                        .map(gameDto -> mapperFacade.map(gameDto, GameDto.class))
                        .orElseThrow(() -> new IllegalArgumentException("There wasn't found game with id = " + id))
        );
    }

    @Override
    public Mono<GameDto> updateGame(GameDto gameDto) {
        Game game = gameRepository.getOne(gameDto.getId());
        game.setId(gameDto.getId());
        game.setGameName(gameDto.getGameName());
        game.getUserNames().addAll(gameDto.getUserNames());
        return Mono.when((Iterable<? extends Publisher<?>>) gameRepository.save(game))
                .then(Mono.fromSupplier(() -> gameDto));
    }

    @Override
    public Mono<Void> deleteGame(UUID id) {
        return Mono.fromRunnable(() -> gameRepository.deleteById(id));
    }

    @Override
    public Flux<GameDto> getGames(Search<GameSearchDto> gameSearchDto) {
        return Flux.fromIterable(gameRepository.findAll(getSpec(gameSearchDto.getData()), getOf(gameSearchDto)))
                .map(game -> new GameDto(game.getId(), game.getGameName(), game.getUserNames()));
    }

    private PageRequest getOf(Search<GameSearchDto> gameSearchDto) {
        var page = gameSearchDto.getPage();
        return PageRequest.of(page.getPage(), page.getSize());
    }

    private Specification<Game> getSpec(GameSearchDto gameSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (gameSearchDto.getGameName() != null) {
                predicates.add(root.get("game_name").in(gameSearchDto.getGameName()));
            }
            return builder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
