package ru.tablegame.resource.dto.game;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * объекты для игры получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "объекты для игры получаемые с контролеров")
public class GameDto implements Serializable {
    private static final long serialVersionUID = -619218161382592660L;

    /**
     * id игры
     */
    @ApiModelProperty(value = "id игры",  required = true)
    private UUID id;

    /**
     * название игры
     */
    @ApiModelProperty(value = "название игры",  required = true)
    private String gameName;

    /**
     * юзаеры в этой игре
     */
    @ApiModelProperty(value = "юзаеры в этой игре")
    private List<String> userNames;

}
