package tablegame.service;

import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;

/**
 * @author nemykin 29.10.2020
 */
public interface CreateGameService {

    GameDto regGame(UserDto userDto, GameDto gameDto);
}
