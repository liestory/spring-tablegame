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
import ru.tablegame.controller.dto.GameDto;
import ru.tablegame.service.GameService;
import ru.tablegame.validator.GameDtoValidator;

import java.util.List;

/**
 * @author nemykin 09.12.2020
 */
@RestController
@RequestMapping("/api/v1/game")
@Slf4j
public class GameController {

    private GameService gameService;
    private GameDtoValidator gameDtoValidator;

    public GameController(GameService gameService, GameDtoValidator gameDtoValidator) {
        this.gameService = gameService;
    }
    //GET, PUT, POST, DELETE

    /**
     * блок CRUD
     */
    @PostMapping()
    public ResponseEntity<GameDto> gameRegistration(@RequestBody GameDto gameDto) {
        gameService.regGame(gameDto);
        return new ResponseEntity<>(gameDto, HttpStatus.CREATED);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<GameDto> getCharacter(@PathVariable("id") Long id) {
        return new ResponseEntity<>(gameService.getUser(id), HttpStatus.FOUND);
    }

    //UPDATE
    @PutMapping
    public ResponseEntity updateCharacter(@RequestBody GameDto gameDto) {
        gameService.updateUser(gameDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity deleteCharacter(@PathVariable("id") Long id) {
        gameService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * для будущего расширения! пока они не важны
     * TODO: надо лучше обдумать верно ли я добавляю юзеров в системе в игры.
     */
    @PostMapping(value = "/set_users")
    public ResponseEntity setUsersForGame(@RequestBody GameDto gameDto) {
        gameService.addUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUserNameList()));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/update_users")
    public ResponseEntity<GameDto> updateUsersForGame(@RequestBody GameDto gameDto) {
        return new ResponseEntity<>(gameService.updateUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUserNameList())), HttpStatus.OK);
    }

    @PostMapping(value = "/delete_users")
    public ResponseEntity deleteUsersForGame(@RequestBody GameDto gameDto) {
        gameService.deleteUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUserNameList()));
        return new ResponseEntity(HttpStatus.OK);
    }

}
