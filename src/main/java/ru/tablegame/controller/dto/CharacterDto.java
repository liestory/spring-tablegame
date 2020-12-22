package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.tablegame.model.Characteristics;
import ru.tablegame.model.CharacteristicsBase;
import ru.tablegame.model.Inventory;

import java.io.Serializable;

/**
 * получение карточки персонажа с контролера
 *
 * @author nemykin 08.12.2020
 */
@Getter
@Setter
@ToString
public class CharacterDto implements Serializable {
    private static final long serialVersionUID = 4779865364094609955L;

    public CharacterDto() {
    }

    /**
     * id персонажа
     */
    private Long id;

    /**
     * имя юзера
     */
    private String userName;

    /**
     * имя персонажа
     */
    private String characterName;

    /**
     * список характеристик для персонажа
     */
    private Characteristics characteristics;

    /**
     * базовый список характеристик для персонажа
     */
    private CharacteristicsBase characteristicsBase;
    /**
     * уровень персонажа
     */
    private int level;

    /**
     * инвентарь персонажа
     */
    private Inventory inventory;

    /**
     * название игры
     */
    private String gameName;

    /**
     * описание статуса персонажа
     */
    private String statusDesc;

}
