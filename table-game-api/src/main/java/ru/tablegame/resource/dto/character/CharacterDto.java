package ru.tablegame.resource.dto.character;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tablegame.model.Characteristics;
import ru.tablegame.model.CharacteristicsBase;
import ru.tablegame.model.Inventory;

import java.io.Serializable;
import java.util.UUID;

/**
 * получение карточки персонажа с контролера
 *
 * @author nemykin 08.12.2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "карточка персонажа с контролера")
public class CharacterDto implements Serializable {
    private static final long serialVersionUID = 4779865364094609955L;

    /**
     * id персонажа
     */
    @ApiModelProperty(value = "id персонажа", required = true)
    private UUID id;

    /**
     * имя юзера
     */
    @ApiModelProperty(value = "id имя юзера", required = true)
    private String userName;

    /**
     * имя персонажа
     */
    @ApiModelProperty(value = "имя персонажа", required = true)
    private String characterName;

    /**
     * список характеристик для персонажа
     */
    @ApiModelProperty(value = "список характеристик для персонажа")
    private Characteristics characteristics;

    /**
     * базовый список характеристик для персонажа
     */
    @ApiModelProperty(value = "базовый список характеристик для персонажа")
    private CharacteristicsBase characteristicsBase;
    /**
     * уровень персонажа
     */
    @ApiModelProperty(value = "уровень персонажа")
    private int level;

    /**
     * инвентарь персонажа
     */
    @ApiModelProperty(value = "инвентарь персонажа")
    private Inventory inventory;

    /**
     * название игры
     */
    @ApiModelProperty(value = "название игры", required = true)
    private String gameName;

    /**
     * описание статуса персонажа
     */
    @ApiModelProperty(value = "описание статуса персонажа", required = true,
            example = "Создан", allowableValues = "Создан, Не активен, Активен, В бою, В зоне отдыха, Мертв")
    private String statusDesc;

}
