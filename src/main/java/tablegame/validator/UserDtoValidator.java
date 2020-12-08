package tablegame.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tablegame.controller.dto.UserDto;

import java.util.Locale;

/**
 * проверки для UserDto
 *
 * @author Asus 28.10.2020
 */

@Component
@Slf4j
public class UserDtoValidator {

    private MessageSource messageSource;

    public UserDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(UserDto userDto) {
        if (userDto.getUsername().isEmpty()) {
            log.error("Логин пустой");
            throw new NullPointerException("Логин пустой");
        }
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            log.error("Пароли не совпадают");
            throw new RuntimeException("Пароли не совпадают");
        }
    }
}
