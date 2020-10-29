package tablegame.service;

import tablegame.controller.dto.GameDto;

/**
 * @author nemykin 29.10.2020
 */
public interface CreateGameService {

    GameDto regGame(GameDto gameDto);
}
