package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @author nemykin 08.12.2020
 */
@Getter
@Setter
public class CharacterDto {


    /**
     * id персонажа
     */
    private Long id;

    /**
     * Имя юзера
     */
    private String userName;

    /**
     * список ошибок
     */
    private List<ObjectError> errors;

}
