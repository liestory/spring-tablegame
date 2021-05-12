package ru.tablegame.resource.dto.game;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * карточка игры для пагинационного поиска
 *
 * @author nemykin 19.01.2021
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@ApiModel(description = "карточка игры для пагинационного поиска")
public class GameSearchDto {

    /**
     * название игры
     */
    @ApiModelProperty(value = "название игры")
    private String gameName;

    /**
     * время создания
     */
    @ApiModelProperty(value = "время создания")
    String createAt;
}
