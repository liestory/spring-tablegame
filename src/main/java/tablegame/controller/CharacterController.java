package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.CharacterDto;
import tablegame.controller.dto.GameDto;
import tablegame.service.CreateCharacterService;

import java.util.UUID;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/character")
@Slf4j
public class CharacterController {
    private CreateCharacterService createCharacterService;

    public CharacterController(CreateCharacterService createCharacterService) {
        this.createCharacterService = createCharacterService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CharacterDto userRegistration(@RequestBody CharacterDto characterDto, BindingResult result) {
        if (result.hasErrors()) {
            characterDto.setErrors(result.getAllErrors());
            return characterDto;
        }
        createCharacterService.createCharacter(characterDto);
        return characterDto;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public CharacterDto getCharacter(@RequestParam("id") UUID idUser,
                                     @RequestParam("game") String gameName,
                                     BindingResult result) {
        return null;
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public void setUsersForGame(@RequestBody GameController.UsersForGameRq rq, BindingResult result) {
//        gameService.addUserToGame(rq.game, rq.users);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public GameDto updateUsersForGame(@RequestBody GameController.UsersForGameRq rq, BindingResult bindingResult) {
//        return gameService.updateUserToGame(rq.game, rq.users);
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteUsersForGame(@RequestBody GameController.UsersForGameRq rq, BindingResult bindingResult) {
//        gameService.deleteUserToGame(rq.game, rq.users);
    }

}
