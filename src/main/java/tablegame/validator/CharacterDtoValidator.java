package tablegame.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import tablegame.controller.dto.CharacterDto;

/**
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
    }
}
