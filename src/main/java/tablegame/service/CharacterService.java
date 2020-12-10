package tablegame.service;

import tablegame.controller.dto.CharacterDto;


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
     * убийство персонажа (перевод в статус смерть)
     *
     * @param characterDto - карточка персонажа от клиента
     */
    void killCharacter(CharacterDto characterDto);
}