package ru.tablegame.auth.resource.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author nemykin 19.03.2021
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "карточка для выдачи сгенерированного токена")
public class TokenDto {

    @ApiModelProperty(value = "Токен пользователя", required = true)
    private String token;

}
