package tablegame.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import tablegame.controller.dto.UserDto;

/**
 * TODO: мало ли осилю валидацию. пока просто зачаток
 *
 * @author Asus 28.10.2020
 */
@Component
public class UserDtoValidator {

    private MessageSource messageSource;
    private static final Logger logger = LogManager.getLogger(UserDtoValidator.class.getName());

    public UserDtoValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void validate(UserDto userForm) {
        if (!userForm.getPassword().equals(userForm.getRepeatPassword())) {
            logger.error("Пароли не совпадают");
            throw new RuntimeException("Пароли не совпадают");
        }
    }
}
