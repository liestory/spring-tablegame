package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * данные о юзере
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
public class UserDto {

    /**
     *  id юзера
     */
    private UUID id;

    /**
     * имя юзера (логин)
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
