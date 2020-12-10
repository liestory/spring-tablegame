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
import tablegame.controller.dto.CharacteristicsDto;
import tablegame.model.Character;
import tablegame.model.Game;
import tablegame.service.CharacterService;
import tablegame.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@RequestMapping("/api/character")
@Slf4j
public class CharacterController {
    private CharacterService characterService;
    private UserService userService;

    public CharacterController(CharacterService characterService, UserService userService) {
        this.characterService = characterService;
        this.userService = userService;
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
    public List<CharacterDto> getCharacter(@RequestParam("id") UUID userId,
                                           @RequestParam("game") String gameName,
                                           BindingResult result) {
        Map<Game, Character> gameCharacterMap = userService.getCharacterByUserIdAndGameName(userId, gameName);
        List<CharacterDto> characterDtos = new ArrayList<>();
        for (Character character : gameCharacterMap.values()) {
            CharacterDto characterDto = new CharacterDto();
            characterDto.setId(character.getId());
            characterDto.setCharacterName(character.getCharacterName());
            characterDto.setGameName(gameName);
            characterDto.setLevel(character.getLevel());
            characterDto.setCharacteristicsDto(new CharacteristicsDto(
                    character.getCharacterName(),
                    character.getCharacteristics().getStrength(),
                    character.getCharacteristics().getDexterity(),
                    character.getCharacteristics().getConstitution(),
                    character.getCharacteristics().getIntelligent(),
                    character.getCharacteristics().getWisdom(),
                    character.getCharacteristics().getCharisma()
            ));
            characterDtos.add(characterDto);
        }
        return characterDtos;
    }
}
