package tablegame.service;

import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;

/**
 * @author Asus 28.10.2020
 */
public interface RegistrationService {

    UserDto regUser(UserDto userDto);

}
