package ru.tablegame.auth.resource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * запрос на получение страницы с пагинацией
 *
 * @author nemykin 16.01.2020
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "карточки ошибки.")
public class Search<T> {

    /**
     * данные для поиска
     */
    @ApiModelProperty(value = "данные для поиска")
    T data;

    /**
     * карточка страницы
     */
    @ApiModelProperty(value = "карточка страницы")
    Page page;

}
