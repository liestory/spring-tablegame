package tablegame.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.UserDto;
import tablegame.service.UserService;

/**
 * @author nemykin 03.11.2020
 */
@RestController
@RequestMapping("/api/admin/panel")
public class AdminPanelController {

    private static final Logger logger = LogManager.getLogger(RegistrationUserController.class.getName());

    private UserService userService;

    public AdminPanelController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/change_status", method = RequestMethod.POST)
    public UserDto userRegistration(@Validated @RequestBody UserDto userDto, BindingResult result
            /*, HttpServletRequest httpServletRequest*/) {
        if (result.hasErrors()) {
            userDto.setErrors(result.getAllErrors());
            return userDto;
        }
        //TODO: подумать о том как правильно сделать тут DTO для настройки админом других пользователей
       // userService.changeRole(userDto);
        return userDto;
    }
}
