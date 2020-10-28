package tablegame.service;

import org.springframework.context.annotation.Bean;
import tablegame.dao.GameDAO;
import tablegame.dao.UserDAO;

/**
 * опивание свяки сервисов
 *
 * @author nemykin 21.10.2020
 */
public class ServiceConfig {

    @Bean
    public UserService userServiceImpl(UserDAO userDAO) {
        return new UserServiceImpl(userDAO);
    }

    @Bean
    public GameService gameServiceImpl(GameDAO gameDAO) {
        return new GameServiceImpl(gameDAO);
    }

    @Bean
    public RegistrationService registrationService(UserDAO userDAO) {
        return new RegistrationServiceImpl(userDAO);
    }
}