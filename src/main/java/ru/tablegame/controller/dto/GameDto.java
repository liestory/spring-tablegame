package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;
import ru.tablegame.model.User;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * объекты для юзера получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
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
     * юзаеры в этой игре
     */
    private Set<User> users;

    /**
     * список ошибок
     */
    private List<ObjectError> errors;

    @Override
    public int hashCode() {
        return Objects.hash(id, gameName, users);
    }
}
