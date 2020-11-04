package tablegame.controller.dto;

import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * данные о юзере
 *
 * @author nemykin 28.10.2020
 */
public class UserDto {

    public UserDto() {
    }

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, repeatPassword);
    }
}
