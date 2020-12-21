package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * объекты для игр получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
public class UserDto {

    public UserDto() {
    }

    /**
     * id юзера
     */
    private UUID id;

    /**
     * логин юзера
     */
    private String username;

    /**
     * пароль юзера
     */
    private String password;

    /**
     * повтор пароля
     */
    private String repeatPassword;

    /**
     * статус юзера
     */
    private String status;

    /**
     * список ошибок
     */
    private List<ObjectError> errors;


}
