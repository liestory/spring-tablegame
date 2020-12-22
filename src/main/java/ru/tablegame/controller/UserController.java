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
import ru.tablegame.controller.dto.UserDto;
import ru.tablegame.service.UserService;
import ru.tablegame.validator.UserDtoValidator;

import java.util.Objects;
import java.util.UUID;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private UserService userService;
    private UserDtoValidator userDtoValidator;

    public UserController(UserService userService, UserDtoValidator userDtoValidator) {
        this.userService = userService;
        this.userDtoValidator = userDtoValidator;
    }

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    public ResponseEntity<UserDto> createCharacter(@RequestBody UserDto userDto, UriComponentsBuilder componentsBuilder) {
        log.info("create with {} - start ", userDto);
        userDtoValidator.validate(userDto);
        var result = userService.regUser(userDto);
        var uri = componentsBuilder.path("/api/v1/user/" + result.getId()).buildAndExpand(result).toUri();
        log.info("create with {} - end", result);
        return ResponseEntity.created(uri).body(result);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getCharacter(@PathVariable("id") UUID id) {
        log.info("get with {} - start ", id);
        var result = userService.getUser(id);
        log.info("get end with {}, with result {}", id, result);
        return ResponseEntity.ok().body(result);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity updateCharacter(@RequestBody UserDto userDto, @PathVariable("id") UUID id) {
        log.info("update with {} - start ", userDto);
        if (!Objects.equals(id, userDto.getId())) {
            throw new IllegalArgumentException("id=" + userDto.getId() + ": expected same as " + id);
        }
        userDtoValidator.validate(userDto);
        var result = userService.updateUser(userDto);
        log.info("update with {} - end", result);
        return ResponseEntity.ok().body(result);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity deleteCharacter(@PathVariable("id") UUID id) {
        log.info("delete with {} - start ", id);
        userService.deleteUser(id);
        log.info("delete end with {}", id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
