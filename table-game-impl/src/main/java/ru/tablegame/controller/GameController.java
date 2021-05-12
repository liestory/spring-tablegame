package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.aspect.annotation.Audit;
import ru.tablegame.aspect.annotation.AuditCode;
import ru.tablegame.resource.GameResource;
import ru.tablegame.resource.dto.PageDto;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.game.GameDto;
import ru.tablegame.resource.dto.game.GameSearchDto;
import ru.tablegame.service.GameService;
import ru.tablegame.validator.GameDtoValidator;

import java.net.URI;
import java.util.Objects;
import java.util.UUID;

/**
 * @author nemykin 09.12.2020
 */
@RestController
@Slf4j
public class GameController implements GameResource {

    private GameService gameService;
    private GameDtoValidator gameDtoValidator;

    public GameController(GameService gameService,
                          GameDtoValidator gameDtoValidator) {
        this.gameService = gameService;
        this.gameDtoValidator = gameDtoValidator;
    }
    //GET, PUT, POST, DELETE

    /**
     * блок CRUD
     */
    @Override
    @Audit(AuditCode.GAME_CREATE)
    public Mono<ResponseEntity<GameDto>> gameRegistration(@RequestBody GameDto gameDto, UriComponentsBuilder componentsBuilder) {
        log.debug("create with {} - start ", gameDto);
        gameDtoValidator.validate(gameDto);
        var result = gameService.regGame(gameDto);
        return result.flatMap(createGameDto -> {
            URI uri = componentsBuilder.path("/api/v1/location/" + createGameDto.getId()).buildAndExpand(result).toUri();
            return Mono.just(ResponseEntity.created(uri).body(createGameDto));
        }).doOnSuccess(rs -> log.debug("create end with result {}", rs));
    }

    //GET
    @Override
    @Audit(AuditCode.GAME_GET)
    public Mono<ResponseEntity<GameDto>> getGame(@PathVariable("id") UUID id) {
        log.debug("get with {} - start ", id);
        var result = gameService.getGame(id);
        return result
                .flatMap(gameResult -> Mono.just(ResponseEntity.ok().body(gameResult)))
                .doOnSuccess(game -> log.debug("get end with {}, with result {}", id, game));
    }

    //UPDATE
    @Override
    @Audit(AuditCode.GAME_UPDATE)
    public Mono<ResponseEntity<GameDto>> updateGame(@RequestBody GameDto gameDto, @PathVariable("id") UUID id) {
        log.debug("update with {} - start ", gameDto);
        if (!Objects.equals(id, gameDto.getId())) {
            throw new IllegalArgumentException("id=" + gameDto.getId() + ": expected same as " + id);
        }
        gameDtoValidator.validate(gameDto);
        var result = gameService.updateGame(gameDto);
        return result
                .flatMap(gameResult -> Mono.just(ResponseEntity.ok().body(gameResult)))
                .doOnSuccess(game -> log.debug("update with {} - end", game));
    }

    //delete
    @Override
    @Audit(AuditCode.GAME_DELETE)
    public Mono<ResponseEntity> deleteGame(@PathVariable("id") UUID id) {
        log.debug("delete with {} - start ", id);
        var result = gameService.deleteGame(id);
        return result.flatMap(responseResult -> Mono.just(new ResponseEntity(HttpStatus.OK)))
                .doOnSuccess(game -> log.debug("delete with {} - end", id));
    }

    @Override
    public Flux<GameDto> getGames(@RequestBody Search<GameSearchDto> gameSearchDto) {
        log.debug("getGames with {} - start ", gameSearchDto);
        var result = gameService.getGames(gameSearchDto);
        log.debug("getGames end with {}, with result {}", gameSearchDto, result);
        return result;
    }
}
