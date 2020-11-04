package tablegame.service;

import org.springframework.context.annotation.Bean;
import tablegame.dao.GameDAO;
import tablegame.dao.UserDAO;

/**
 * описание связки сервисов
 *
 * @author nemykin 21.10.2020
 */
public class ServiceConfig {

    @Bean
    public UserService userService(UserDAO userDAO) {
        return new UserServiceImpl(userDAO);
    }

    @Bean
    public GameService gameService(GameDAO gameDAO) {
        return new GameServiceImpl(gameDAO);
    }

    @Bean
    public RegistrationService registrationService(UserDAO userDAO) {
        return new RegistrationServiceImpl(userDAO);
    }

    @Bean
    public CreateGameService createGameService(GameDAO gameDAO) {
        return new CreateGameServiceImpl(gameDAO);
    }
}

