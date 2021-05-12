package ru.tablegame.resource.dto.character;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * карточка персонажа для пагинационного поиска
 *
 * @author nemykin 19.01.2021
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@ApiModel(description = "карточка персонажа для пагинационного поиска")
public class CharacterSearchDto {

    /**
     * имя персонажа
     */
    @ApiModelProperty(value = "имя персонажа")
    private String characterName;

    /**
     * название игры
     */
    @ApiModelProperty(value = "название игры")
    private String gameName;

    /**
     * имя юзера
     */
    @ApiModelProperty(value = "имя юзера")
    private String userName;

    /**
     * время создания
     */
    @ApiModelProperty(value = "время создания")
    String createAt;
}
