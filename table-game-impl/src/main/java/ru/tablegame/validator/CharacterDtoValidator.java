package ru.tablegame.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.tablegame.resource.dto.character.CharacterDto;

/**
 * валидация карточки персонажа с контроллера
 *
 * @author nemykin 08.12.2020
 */
@Slf4j
@Component
public class CharacterDtoValidator {
    private MessageSource messageSource;

    public CharacterDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(CharacterDto characterDto) {
        if (characterDto.getUserName().isEmpty()) {
            log.error("Логин для привязки персонажа пуст");
            throw new NullPointerException("Логин пустой");
        }
        if (characterDto.getGameName().isEmpty()) {
            log.error("Нет названия игры для привязки персонажа");
            throw new NullPointerException("имя игры пустое");
        }
        if (characterDto.getLevel() <= 0) {
            log.error("Уровень персонажа не может быть отрицательным");
            throw new IllegalArgumentException("Отрицательный уровень персонажа");
        }
    }
}
