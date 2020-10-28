package tablegame.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.service.RegistrationService;

/**
 * @author nemykin 28.10.2020
 */
@RestController
@RequestMapping("/api/registration")
public class RegistrationUserController {

    private static final Logger logger = LogManager.getLogger(RegistrationUserController.class.getName());

    private RegistrationService registrationService;
//    private UserDtoValidator userDtoValidator;

    @Autowired
    public RegistrationUserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
//        this.userDtoValidator = userDtoValidator;
    }


    @RequestMapping(method = RequestMethod.POST)
    public UserDto userRegistration(@Validated @RequestBody UserDto userDto, BindingResult result
            /*, HttpServletRequest httpServletRequest*/) {
        if (result.hasErrors()) {
            userDto.setErrors(result.getAllErrors());
            return userDto;
        }

        registrationService.regUser(userDto);
        return userDto;
    }

    @RequestMapping(method = RequestMethod.POST)
    public GameDto gameRegistration(@Validated @RequestBody GameDto gameDto, BindingResult result
            /*, HttpServletRequest httpServletRequest*/) {
        if (result.hasErrors()) {
            gameDto.setErrors(result.getAllErrors());
            return gameDto;
        }

        registrationService.regGame(gameDto);
        return gameDto;
    }
}
