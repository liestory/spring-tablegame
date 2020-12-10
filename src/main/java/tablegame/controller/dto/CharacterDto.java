package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author nemykin 08.12.2020
 */
@Getter
@Setter
public class CharacterDto {


    //TODO: здесь глобальная проблема маппинга через Jackson (ошибка ниже). Я пока не нашел способа решения.
    //      Такая же ошибка была когда я использовал Map<Object, Object>. Но сейчас все значеня верные. Буду рад помощи
    //      Failed to evaluate Jackson deserialization for type [[simple type, class tablegame.controller.dto.GameDto]]
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

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, characterName, characteristicsDto, level, gameName);
    }
}
