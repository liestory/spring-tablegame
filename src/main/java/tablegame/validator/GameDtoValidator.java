package tablegame.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import tablegame.controller.dto.GameDto;

/**
 * @author nemykin 08.12.2020
 */
@Slf4j
@Component
public class GameDtoValidator {
    private MessageSource messageSource;

    public GameDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(GameDto gameDto) {
        if (gameDto.getGameName().isEmpty()) {
            log.error("Нет названия игры");
            throw new NullPointerException("Нет названия игры");
        }
    }

}
