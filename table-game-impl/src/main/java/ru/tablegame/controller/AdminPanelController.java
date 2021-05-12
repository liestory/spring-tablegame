package ru.tablegame.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@AllArgsConstructor
public class AdminPanelController {


//    @PostMapping(value = "/change_status")
//    public UserDto userRegistration(@Validated @RequestBody UserDto userDto, BindingResult result) {
////        if (result.hasErrors()) {
////            userDto.setErrors(result.getAllErrors());
////            return userDto;
////        }
////        //TODO: подумать о том как правильно сделать тут DTO для настройки админом других пользователей
////       // userService.changeRole(userDto);
//        return userDto;
//    }
}
