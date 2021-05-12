package ru.tablegame.auth.resource.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tablegame.auth.model.RoleGlobal;

import java.io.Serializable;
import java.util.UUID;

/**
 * объекты для игр получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "объекты для игр получаемые с контролеров")
public class UserDto implements Serializable {

    private static final long serialVersionUID = 8443900228900286833L;

    /**
     * id юзера
     */
    @ApiModelProperty(value = "id юзера", required = true)
    private UUID id;

    /**
     * логин юзера
     */
    @ApiModelProperty(value = "логин юзера", required = true)
    private String username;

    /**
     * пароль юзера
     */
    @ApiModelProperty(value = "пароль юзера", required = true)
    private String password;

    /**
     * повтор пароля
     */
    @ApiModelProperty(value = "повтор пароля", required = true)
    private String repeatPassword;

    /**
     * почта юзера
     */
    @ApiModelProperty(value = "почта юзера", required = true)
    private String email;

    /**
     * глобальная роль в системе
     */
    @ApiModelProperty(value = "Роль юзера", required = true)
    private RoleGlobal roleGlobal;

}
