package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tablegame.controller.dto.GameDto;
import ru.tablegame.controller.dto.UserDto;
import ru.tablegame.service.GameService;
import ru.tablegame.service.RegistrationService;
import tablegame.controller.dto.UserDto;
import tablegame.service.RegistrationService;
import tablegame.validator.UserDtoValidator;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/registration")
@Slf4j
public class RegistrationController {

    private RegistrationService registrationService;
    private UserDtoValidator userDtoValidator;

    public RegistrationController(RegistrationService registrationService, UserDtoValidator userDtoValidator) {
        this.registrationService = registrationService;
        this.userDtoValidator = userDtoValidator;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> userRegistration(@RequestBody UserDto userDto) {
        userDtoValidator.validate(userDto);
        registrationService.regUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

}
