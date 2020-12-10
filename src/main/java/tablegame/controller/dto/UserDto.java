package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;
import tablegame.model.Character;
import tablegame.model.Game;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * объекты для игр получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
public class UserDto {

    /**
     * id юзера
     */
    private UUID id;

    /**
     * логин юзера
     */
    private String username;

    /**
     * пароль юзера
     */
    private String password;

    /**
     * повтор пароля
     */
    private String repeatPassword;

//    /**
//     * список персонажей привязанных к игре
//     */
//    private Map<Game, Character> gameCharacterMap;

    /**
     * список ошибок
     */
    private List<ObjectError> errors;

    public UserDto() {
    }


    @Override
    public int hashCode() {
        return Objects.hash(username, password, repeatPassword);
    }
}
