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
import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.service.CharacterService;

import java.util.Objects;
import ru.tablegame.validator.CharacterDtoValidator;

import java.util.List;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/v1/character")
@Slf4j
public class CharacterController {
    private CharacterService characterService;
    private CharacterDtoValidator characterDtoValidator;

    public CharacterController(CharacterService characterService,
                               CharacterDtoValidator characterDtoValidator) {
        this.characterService = characterService;
        this.characterDtoValidator = characterDtoValidator;
    }

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody CharacterDto characterDto, UriComponentsBuilder componentsBuilder) {
        log.info("create with {} - start ", characterDto);
        characterDtoValidator.validate(characterDto);
        var result = characterService.createCharacter(characterDto);
        var uri = componentsBuilder.path("/api/v1/user/" + result.getId()).buildAndExpand(result).toUri();
        log.info("create with {} - end", result);
        return ResponseEntity.created(uri).body(result);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable("id") Long id) {
        log.info("get with {} - start ", id);
        var result = characterService.getCharacter(id);
        log.info("get end with {}, with result {}", id, result);
        return ResponseEntity.ok().body(result);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<CharacterDto> updateCharacter(@RequestBody CharacterDto characterDto, @PathVariable("id") Long id) {
        log.info("update with {} - start", characterDto);
        if (!Objects.equals(id, characterDto.getId())) {
            throw new IllegalArgumentException("id= " + characterDto.getId() + ": expected same as " + id);
        }
        characterDtoValidator.validate(characterDto);
        var result = characterService.updateCharacter(characterDto);
        log.info("update with {} - end", result);
        return ResponseEntity.ok().body(result);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity deleteCharacter(@PathVariable("id") Long id) {
        log.info("delete with {} - start ", id);
        characterService.deleteCharacter(id);
        log.info("delete end with {}", id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //данный метод нужен, тк я не подразумеваю удаление персонажей в моем приложении.
    @PostMapping("{id}/status")
    public ResponseEntity changeStatusCharacter(@RequestBody CharacterDto characterDto, @PathVariable("id") Long id) {
        log.info("change status with {} - start", characterDto);
        if (!Objects.equals(id, characterDto.getId())) {
            throw new IllegalArgumentException("id= " + characterDto.getId() + ": expected same as " + id);
        }
        characterDtoValidator.validate(characterDto);
        characterService.changeStatusCharacter(id, characterDto);
        log.info("change status with {} - end", id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
