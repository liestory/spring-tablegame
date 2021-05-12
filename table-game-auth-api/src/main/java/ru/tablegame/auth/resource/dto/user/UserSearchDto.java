package ru.tablegame.auth.resource.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * карточка юзера для пагинационного поиска
 *
 * @author nemykin 19.01.2021
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@ApiModel(description = "карточка юзера для пагинационного поиска")
public class UserSearchDto {

    /**
     * логин юзера
     */
    @ApiModelProperty(value = "логин юзера")
    String username;

    /**
     * время создания
     */
    @ApiModelProperty(value = "время создания")
    String createAt;
}
