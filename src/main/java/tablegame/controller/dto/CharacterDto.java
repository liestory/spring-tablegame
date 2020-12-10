package tablegame.controller.dto;

import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Objects;

/**
 * @author nemykin 08.12.2020
 */
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
     *  список характеристик для
     */
    private CharacteristicsDto characteristicsDto;
    /**
     * название игры
     */
    private String gameName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public CharacteristicsDto getCharacteristicsDto() {
        return characteristicsDto;
    }

    public void setCharacteristicsDto(CharacteristicsDto characteristicsDto) {
        this.characteristicsDto = characteristicsDto;
    }
}
