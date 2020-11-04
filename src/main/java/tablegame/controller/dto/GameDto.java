package tablegame.controller.dto;

import org.springframework.validation.ObjectError;
import tablegame.model.User;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * данные об игре
 *
 * @author nemykin 28.10.2020
 */
public class GameDto {

    public GameDto() {
    }

    /**
     * id игры
     */
    private Long id;

    /**
     * название игры
     */
    private String gameName;

    /**
     * список пользователей
     */
    private Set<User> users;

    /**
     * список ошибок
     */
    private List<ObjectError> errors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameName, users);
    }
}
