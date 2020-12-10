package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.service.GameService;
import tablegame.service.RegistrationService;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/registration")
@Slf4j
public class RegistrationUserController {

    private RegistrationService registrationService;
    private GameService gameService;

    public RegistrationUserController(RegistrationService registrationService, GameService gameService) {
        this.registrationService = registrationService;
        this.gameService = gameService;
    }

    @PostMapping(value = "/user")
    public UserDto userRegistration(@RequestBody UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            userDto.setErrors(result.getAllErrors());
            return userDto;
        }
        registrationService.regUser(userDto);
        return userDto;
    }

    @PostMapping(value = "/game")
    public GameDto gameRegistration(@RequestBody GameDto gameDto, BindingResult result) {
        if (result.hasErrors()) {
            gameDto.setErrors(result.getAllErrors());
            return gameDto;
        }
        gameService.regGame(gameDto);
        return gameDto;
    }
}
