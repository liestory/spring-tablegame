package ru.tablegame.service;

import ru.tablegame.controller.dto.UserDto;

/**
 * Сервисы регистраций
 *
 * @author Asus 28.10.2020
 */
public interface RegistrationService {

    /**
     * регистрация пользователя
     *
     * @param userDto - карточка пользователя с формы регистрации
     * @return
     */
    UserDto regUser(UserDto userDto);

}
