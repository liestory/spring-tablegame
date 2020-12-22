package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * объекты для игр получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8443900228900286833L;
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
     * список персонажей
     */
    private List<Character> characterList;

    public UserDto() {
    }


}
