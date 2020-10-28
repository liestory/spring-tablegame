package tablegame.controller.dto;

import org.springframework.validation.ObjectError;
import tablegame.model.User;

import java.util.List;
import java.util.Set;

/**
 * @author nemykin 28.10.2020
 */
public class GameDto {

    public GameDto() {
    }

    private Long id;
    private String gameName;
    private Set<User> users;
    private List<ObjectError> errors;
}
