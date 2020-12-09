package tablegame.service;

import tablegame.controller.dto.GameDto;

/**
 * @author nemykin 29.10.2020
 */
public interface CreateGameService {

    /**
     * создание игры
     *
     * @param gameDto - карта данных от клиента
     * @return - заполненая карта после создания
     */
    GameDto regGame(GameDto gameDto);
}
