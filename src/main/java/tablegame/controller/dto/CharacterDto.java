package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;

/**
 * @author nemykin 08.12.2020
 */
@Getter
@Setter
public class CharacterDto {

    public CharacterDto() {
    }

    /**
     * id персонажа
     */
    private Long id;

    /**
     * имя юзера
     */
    private String userName;

    /**
     * имя персонажа
     */
    private String characterName;

    /**
     * список характеристик для
     */
    private CharacteristicsDto characteristicsDto;

    /**
     * уровень персонажа
     */
    private int level;

    /**
     * название игры
     */
    private String gameName;

    /**
     * список ошибок
     */
    private List<ObjectError> errors;

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, characterName, characteristicsDto, level, gameName);
    }
}
