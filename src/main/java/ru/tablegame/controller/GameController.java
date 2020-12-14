package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tablegame.controller.dto.GameDto;
import ru.tablegame.service.GameService;
import tablegame.validator.GameDtoValidator;

import java.util.List;

/**
 * @author nemykin 09.12.2020
 */
@RestController
@RequestMapping("/api/game")
@Slf4j
public class GameController {

    private GameService gameService;
    private GameDtoValidator gameDtoValidator;

    public GameController(GameService gameService, GameDtoValidator gameDtoValidator) {
        this.gameService = gameService;
        this.gameDtoValidator = gameDtoValidator;
    }

    @PostMapping("/create")
    public ResponseEntity<GameDto> gameRegistration(@RequestBody GameDto gameDto) {
        gameDtoValidator.validate(gameDto);
        gameService.regGame(gameDto);
        return new ResponseEntity<>(gameDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/set_users")
    public ResponseEntity setUsersForGame(@RequestBody GameDto gameDto) {
        gameDtoValidator.validate(gameDto);
        gameService.addUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUserNameList()));
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/update_users")
    public ResponseEntity<GameDto> updateUsersForGame(@RequestBody GameDto gameDto) {
        gameDtoValidator.validate(gameDto);
        return new ResponseEntity<>(gameService.updateUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUserNameList())), HttpStatus.OK);
    }

    @PostMapping(value = "/delete_users")
    public ResponseEntity deleteUsersForGame(@RequestBody GameDto gameDto) {
        gameDtoValidator.validate(gameDto);
        gameService.deleteUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUserNameList()));
        return new ResponseEntity(HttpStatus.OK);
    }


}
