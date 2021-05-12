package ru.tablegame.auth.resource.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * карточка для аутентификации
 *
 * @author nemykin 19.03.2021
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "карточка для аутентификации")
public class AuthUserDto {

    /**
     * Имя пользователя
     */
    @ApiModelProperty(value = "имя юзера",  required = true)
    private String userName;

    /**
     * Пароль пользователя
     */
    @ApiModelProperty(value = "пароль юзера", required = true)
    private String password;

}
