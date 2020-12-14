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
import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.service.CharacterService;
import ru.tablegame.service.UserService;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/v1/character")
@Slf4j
public class CharacterController {
    private CharacterService characterService;
    private UserService userService;

    public CharacterController(CharacterService characterService, UserService userService) {
        this.characterService = characterService;
        this.userService = userService;
    }

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody CharacterDto characterDto) {
        characterService.createCharacter(characterDto);
        return new ResponseEntity<>(characterDto, HttpStatus.CREATED);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable("id") Long id) {
        return new ResponseEntity<>(characterService.getCharacter(id), HttpStatus.FOUND);
    }

    //UPDATE
    @PutMapping
    public ResponseEntity updateCharacter(@RequestBody CharacterDto characterDto) {
        characterService.updateCharacter(characterDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity deleteCharacter(@PathVariable("id") Long id) {
        characterService.deleteCharacter(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //данный метод нужен, тк я не подразумеваю удаление персонажей в моем прилоэении.
    @PostMapping("/kill/{id}")
    public ResponseEntity killCharacter(@PathVariable("id") Long id) {
        characterService.killCharacter(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
