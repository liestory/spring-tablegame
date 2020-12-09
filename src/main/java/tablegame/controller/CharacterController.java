package tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tablegame.controller.dto.CharacterDto;
import tablegame.service.CreateCharacterService;
import tablegame.validator.CharacterDtoValidator;

import java.util.UUID;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/character")
@Slf4j
public class CharacterController {
    private CreateCharacterService createCharacterService;
    private CharacterDtoValidator characterDtoValidator;

    @Autowired
    public CharacterController(CreateCharacterService createCharacterService,
                               CharacterDtoValidator characterDtoValidator) {
        this.createCharacterService = createCharacterService;
        this.characterDtoValidator = characterDtoValidator;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CharacterDto userRegistration(@Validated @RequestBody CharacterDto characterDto, BindingResult result) {
        if (result.hasErrors()) {
            characterDto.setErrors(result.getAllErrors());
            return characterDto;
        }
        characterDtoValidator.validate(characterDto);
        createCharacterService.createCharacter(characterDto);
        return characterDto;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public CharacterDto getCharacter(@RequestParam("id") UUID idUser,
                                     @RequestParam ("game") String gameName,
                                     BindingResult result) {

        return null;
    }

}
