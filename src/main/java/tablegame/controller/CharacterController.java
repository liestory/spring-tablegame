package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.CharacterDto;
import tablegame.service.CharacterService;

import java.util.UUID;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/character")
@Slf4j
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping(value = "/create")
    public CharacterDto userRegistration(@RequestBody CharacterDto characterDto, BindingResult result) {
        if (result.hasErrors()) {
            characterDto.setErrors(result.getAllErrors());
            return characterDto;
        }
        characterService.createCharacter(characterDto);
        return characterDto;
    }

    @GetMapping(value = "/get")
    public CharacterDto getCharacter(@RequestParam("id") UUID idUser,
                                     @RequestParam("game") String gameName,
                                     BindingResult result) {
        return null;
    }
}
