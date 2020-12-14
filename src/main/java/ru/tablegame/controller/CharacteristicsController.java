package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/set")
    public ResponseEntity setUsersForGame(@RequestBody CharacteristicsDto characteristicsDto) {
        characteristicsService.addCharacterCharacteristics(characteristicsDto.getCharacterName(), characteristicsDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<CharacteristicsDto> updateUsersForGame(@RequestBody CharacteristicsDto characteristicsDto) {
        return new ResponseEntity<>(characteristicsService.updateCharacterCharacteristics(characteristicsDto.getCharacterName(), characteristicsDto),
                HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity deleteUsersForGame(@RequestBody CharacteristicsDto characteristicsDto) {
        characteristicsService.deleteCharacterCharacteristics(characteristicsDto.getCharacterName());
        return new ResponseEntity(HttpStatus.OK);
    }

}
