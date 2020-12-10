package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import tablegame.model.Character;

import java.util.List;
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

    /**
     * список персонажей
     */
    private List<Character> characterList;

    public UserDto() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, repeatPassword, characterList);
    }
}
