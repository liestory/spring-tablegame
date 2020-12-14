package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tablegame.service.UserService;
import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.service.CharacterService;
import tablegame.controller.dto.CharacterDto;
import tablegame.service.CharacterService;
import tablegame.service.UserService;
import tablegame.validator.CharacterDtoValidator;

import java.util.List;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/character")
@Slf4j
public class CharacterController {
    private CharacterService characterService;
    private UserService userService;
    private CharacterDtoValidator characterDtoValidator;

    public CharacterController(CharacterService characterService,
                               UserService userService,
                               CharacterDtoValidator characterDtoValidator) {
        this.characterService = characterService;
        this.userService = userService;
        this.characterDtoValidator = characterDtoValidator;
    }

    @PostMapping("/create")
    public ResponseEntity<CharacterDto> userRegistration(@RequestBody CharacterDto characterDto) {
        characterDtoValidator.validate(characterDto);
        characterService.createCharacter(characterDto);
        return new ResponseEntity<>(characterDto, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CharacterDto>> getCharacter(@RequestParam("userName") String userName,
                                                           @RequestParam("gameName") String gameName) {
        return new ResponseEntity<>(userService.getCharacterByUserNameAndGameName(userName, gameName), HttpStatus.FOUND);
    }

    @PostMapping("/kill")
    public ResponseEntity killCharacter(@RequestBody CharacterDto characterDto) {
        characterDtoValidator.validate(characterDto);
        characterService.killCharacter(characterDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
