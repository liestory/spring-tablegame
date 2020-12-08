package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.service.CreateGameService;
import tablegame.service.RegistrationService;
import tablegame.validator.UserDtoValidator;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/registration")
@Slf4j
public class RegistrationUserController {

    private RegistrationService registrationService;
    private CreateGameService createGameService;
    private UserDtoValidator userDtoValidator;

    @Autowired
    public RegistrationUserController(RegistrationService registrationService, CreateGameService createGameService,
                                      UserDtoValidator userDtoValidator) {
        this.registrationService = registrationService;
        this.createGameService = createGameService;
        this.userDtoValidator = userDtoValidator;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserDto userRegistration(@Validated @RequestBody UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            userDto.setErrors(result.getAllErrors());
            return userDto;
        }
        userDtoValidator.validate(userDto);
        registrationService.regUser(userDto);
        return userDto;
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public GameDto gameRegistration(@Validated @RequestBody UserDto userDto, GameDto gameDto, BindingResult result) {
        if (result.hasErrors()) {
            gameDto.setErrors(result.getAllErrors());
            return gameDto;
        }
        createGameService.regGame(userDto, gameDto);
        return gameDto;
    }
}
