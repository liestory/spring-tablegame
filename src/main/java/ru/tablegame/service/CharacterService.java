package ru.tablegame.service;

import ru.tablegame.controller.dto.CharacterDto;

/**
 * @author nemykin 08.12.2020
 */
public interface CharacterService {

    /**
     * создания персонажа
     *
     * @param characterDto - карточка персонажа от клиента
     * @return - обновленная карточка для клиента
     */
    CharacterDto createCharacter(CharacterDto characterDto);

    /**
     * создания персонажа
     *
     * @param id - id персонажа
     * @return - обновленная карточка для клиента
     */
    CharacterDto getCharacter(Long id);

    /**
     * персонажа
     *
     * @param characterDto - карточка персонажа
     */
    void updateCharacter(CharacterDto characterDto);

    /**
     * удаление персонажа
     * TODO: для логики CRUD присутсвует, но по логике персонажи никогда не должны исчезнуть
     *
     * @param id - id персонажа
     */
    void deleteCharacter(Long id);

    /**
     * убийство персонажа (перевод в статус смерть)
     *
     * @param characterDto - карточка персонажа от клиента
     */
    void killCharacter(CharacterDto characterDto);
}