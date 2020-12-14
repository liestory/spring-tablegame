package ru.tablegame.service;

import ru.tablegame.controller.dto.CharacteristicsDto;

/**
 * @author nemykin 09.12.2020
 */
public interface CharacteristicsService {

    /**
     * добавить характеристики персонажа
     *
     * @param characterName      - имя персонажа
     * @param characteristicsDto - карточка характеристик для персонажа
     */
    void addCharacterCharacteristics(String characterName, CharacteristicsDto characteristicsDto);

    /**
     * обновление списка пользователей
     *
     * @param characterName      - имя персонажа
     * @param characteristicsDto - карточка характеристик для персонажа
     * @return - возват карточки характеристик персонажа
     */
    CharacteristicsDto updateCharacterCharacteristics(String characterName, CharacteristicsDto characteristicsDto);

    /**
     * удалить характеристики персонажа (сделать равными 0)
     *
     * @param characterName - имя персонажа
     */
    void deleteCharacterCharacteristics(String characterName);
}
