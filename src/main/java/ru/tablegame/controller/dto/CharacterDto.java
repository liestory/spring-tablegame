package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import ru.tablegame.model.Characteristics;
import ru.tablegame.model.CharacteristicsBase;
import ru.tablegame.model.Inventory;

/**
 *  получение карточки персонажа с контролера
 *
 * @author nemykin 08.12.2020
 */
@Getter
@Setter
public class CharacterDto {

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

}
