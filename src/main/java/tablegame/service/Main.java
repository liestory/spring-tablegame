package tablegame.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import tablegame.config.SpringConfig;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;
import tablegame.model.UserStatus;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author nemykin 13.10.2020
 */
@Component
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = (UserService) context.getBean("userServiceImpl");
        GameService gameService = (GameService) context.getBean("gameServiceImpl");

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("Player1");
        user.setRole(Role.PLAYER);
        user.setUserStatus(UserStatus.STATUS_ACTIVED);

        userService.addUser(user);

        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setUsername("Admin");
        user2.setRole(Role.ADMIN);
        user2.setUserStatus(UserStatus.STATUS_ACTIVED);
        userService.addUser(user2);

        Set<User> users = new HashSet<>();
        users.add(user);
        users.add(user2);

        Game game = new Game();
        game.setId(1L);
        game.setGameName("Настолка");
        game.setUsers(users);

        gameService.addGame(game);
    }
}
