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
import ru.tablegame.controller.dto.UserDto;
import ru.tablegame.service.UserService;

import java.util.UUID;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/registration")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    public ResponseEntity<UserDto> createCharacter(@RequestBody UserDto userDto) {
        userService.regUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getCharacter(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.FOUND);
    }

    //UPDATE
    @PutMapping
    public ResponseEntity updateCharacter(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity deleteCharacter(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
