package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tablegame.controller.dto.CharacteristicsDto;
import ru.tablegame.service.CharacteristicsService;

/**
 * @author nemykin 10.12.2020
 */
@RestController
@RequestMapping("/api/character/characteristics")
@Slf4j
public class CharacteristicsController {
    private CharacteristicsService characteristicsService;

    public CharacteristicsController(CharacteristicsService characteristicsService) {
        this.characteristicsService = characteristicsService;
    }

    @PostMapping(value = "/set_users")
    public void setUsersForGame(@RequestBody CharacteristicsDto characteristicsDto, BindingResult result) {
        characteristicsService.addCharacterCharacteristics(characteristicsDto.getCharacterName(), characteristicsDto);
    }

    @PostMapping(value = "/update_users")
    public CharacteristicsDto updateUsersForGame(@RequestBody CharacteristicsDto characteristicsDto, BindingResult bindingResult) {
        return characteristicsService.updateCharacterCharacteristics(characteristicsDto.getCharacterName(), characteristicsDto);
    }

    @PostMapping(value = "/delete_users")
    public void deleteUsersForGame(@RequestBody CharacteristicsDto characteristicsDto, BindingResult bindingResult) {
        characteristicsService.deleteCharacterCharacteristics(characteristicsDto.getCharacterName());
    }

}
