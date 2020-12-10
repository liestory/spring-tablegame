package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.GameDto;
import tablegame.service.GameService;

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

    @PostMapping(value = "/set_users")
    public void setUsersForGame(@RequestBody GameDto gameDto, BindingResult result) {
        gameService.addUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUsers()));
    }

    @PostMapping(value = "/update_users")
    public GameDto updateUsersForGame(@RequestBody GameDto gameDto, BindingResult bindingResult) {
        return gameService.updateUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUsers()));
    }

    @PostMapping(value = "/delete_users")
    public void deleteUsersForGame(@RequestBody GameDto gameDto, BindingResult bindingResult) {
        gameService.deleteUserToGame(gameDto.getGameName(), List.copyOf(gameDto.getUsers()));
    }
}
