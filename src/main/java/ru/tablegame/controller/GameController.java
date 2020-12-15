package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import ru.tablegame.controller.dto.GameDto;
import ru.tablegame.service.GameService;
import ru.tablegame.validator.GameDtoValidator;

import java.util.Objects;

/**
 * @author nemykin 09.12.2020
 */
@RestController
@RequestMapping("/api/v1/game")
@Slf4j
public class GameController {

    private GameService gameService;
    private GameDtoValidator gameDtoValidator;

    public GameController(GameService gameService,
                          GameDtoValidator gameDtoValidator) {
        this.gameService = gameService;
    }
    //GET, PUT, POST, DELETE

    /**
     * блок CRUD
     */
    @PostMapping()
    public ResponseEntity<GameDto> gameRegistration(@RequestBody GameDto gameDto, UriComponentsBuilder componentsBuilder) {
        log.info("create with {} - start ", gameDto);
        gameDtoValidator.validate(gameDto);
        var result = gameService.regGame(gameDto);
        var uri = componentsBuilder.path("/api/v1/user/" + result.getId()).buildAndExpand(result).toUri();
        log.info("create with {} - end", result);
        return ResponseEntity.created(uri).body(result);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<GameDto> getGame(@PathVariable("id") Long id) {
        log.info("get with {} - start ", id);
        var result = gameService.getGame(id);
        log.info("get end with {}, with result {}", id, result);
        return ResponseEntity.ok().body(result);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity updateGame(@RequestBody GameDto gameDto, @PathVariable("id") Long id) {
        log.info("update with {} - start ", gameDto);
        if (!Objects.equals(id, gameDto.getId())) {
            throw new IllegalArgumentException("id=" + gameDto.getId() + ": expected same as " + id);
        }
        gameDtoValidator.validate(gameDto);
        var result = gameService.updateGame(gameDto);
        log.info("update with {} - end", result);
        return ResponseEntity.ok().body(result);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity deleteGame(@PathVariable("id") Long id) {
        log.info("delete with {} - start ", id);
        gameService.deleteGame(id);
        log.info("delete end with {}", id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
