package ru.tablegame.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tablegame.controller.dto.UserDto;
import ru.tablegame.service.UserService;

/**
 * Контролел управления юзерами в рамках 1 игры
 * TODO: поидее должна быть логика упраления админом определнной game другиеи users
 *      Пока ее нет и продумываю.
 *
 * @author nemykin 03.11.2020
 */
@RestController
@RequestMapping("/api/admin/panel")
@Slf4j
public class AdminPanelController {

    private UserService userService;

    public AdminPanelController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/change_status", method = RequestMethod.POST)
    public UserDto userRegistration(@Validated @RequestBody UserDto userDto, BindingResult result) {
//        if (result.hasErrors()) {
//            userDto.setErrors(result.getAllErrors());
//            return userDto;
//        }
//        //TODO: подумать о том как правильно сделать тут DTO для настройки админом других пользователей
//       // userService.changeRole(userDto);
        return userDto;
    }
}
