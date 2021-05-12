package ru.tablegame.auth.resource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 *  Карточка пагинации при запросе
 *
 * @author nemykin 16.01.2020
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@ApiModel(description = " Карточка пагинации при запросе")
public class Page {

    /**
     * номер страницы
     */
    @ApiModelProperty(value = "номер страницы")
    int page;

    /**
     *  колличество страниц
     */
    @ApiModelProperty(value = "колличество страниц")
    int size;
}
