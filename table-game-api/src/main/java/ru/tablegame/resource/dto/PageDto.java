package ru.tablegame.resource.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * структура информации с пагинацией для вывода
 *
 * @author nemykin 16.01.2020
 */
@Getter
@AllArgsConstructor
@ToString
@ApiModel(description = "структура информации с пагинацией для вывода")
public class PageDto<T> {

    /**
     * информация для вывода
     */
    @ApiModelProperty(value = "информация для вывода")
    List<T> data;

    /**
     * счетчик
     */
    @ApiModelProperty(value = "счетчик")
    long total;
}
