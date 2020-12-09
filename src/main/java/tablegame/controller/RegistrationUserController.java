package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.service.CreateGameService;
import tablegame.service.RegistrationService;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/registration")
@Slf4j
public class RegistrationUserController {

    private RegistrationService registrationService;
    private CreateGameService createGameService;

    public RegistrationUserController(RegistrationService registrationService, CreateGameService createGameService) {
        this.registrationService = registrationService;
        this.createGameService = createGameService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserDto userRegistration(@RequestBody UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            userDto.setErrors(result.getAllErrors());
            return userDto;
        }
        registrationService.regUser(userDto);
        return userDto;
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public GameDto gameRegistration(@RequestBody GameDto gameDto, BindingResult result) {
        if (result.hasErrors()) {
            gameDto.setErrors(result.getAllErrors());
            return gameDto;
        }
        createGameService.regGame(gameDto);
        return gameDto;
    }
}
