package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.GameDto;
import tablegame.model.User;
import tablegame.service.GameService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author nemykin 09.12.2020
 */
@RestController
@RequestMapping("/api/game")
@Slf4j
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    class UsersForGameRq {
        @NotNull
        List<User> users;

        @NotNull
        String game;
    }

    @RequestMapping(value = "/set_users", method = RequestMethod.POST)
    public void setUsersForGame(@RequestBody UsersForGameRq rq, BindingResult result) {
        gameService.addUserToGame(rq.game, rq.users);
    }

    @RequestMapping(value = "/update_users", method = RequestMethod.POST)
    public GameDto updateUsersForGame(@RequestBody UsersForGameRq rq, BindingResult bindingResult) {
        return gameService.updateUserToGame(rq.game, rq.users);
    }

    @RequestMapping(value = "/delete_users", method = RequestMethod.POST)
    public void deleteUsersForGame(@RequestBody UsersForGameRq rq, BindingResult bindingResult) {
        gameService.deleteUserToGame(rq.game, rq.users);
    }
}
