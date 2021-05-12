package ru.tablegame.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.aspect.annotation.Audit;
import ru.tablegame.aspect.annotation.AuditCode;
import ru.tablegame.resource.CharacterResource;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.resource.dto.character.CharacterSearchDto;
import ru.tablegame.service.CharacterService;
import ru.tablegame.validator.CharacterDtoValidator;

import java.net.URI;
import java.util.Objects;
import java.util.UUID;

/**
 * @author nemykin 08.12.2020
 */
@RestController
@Slf4j
public class CharacterController implements CharacterResource {
    private CharacterService characterService;
    private CharacterDtoValidator characterDtoValidator;

    public CharacterController(CharacterService characterService,
                               CharacterDtoValidator characterDtoValidator) {
        this.characterService = characterService;
        this.characterDtoValidator = characterDtoValidator;
    }

    /**
     * блок CRUD
     */
    //create
    @Override
    @Audit(AuditCode.CHARACTER_CREATE)
    public Mono<ResponseEntity<CharacterDto>> createCharacter(@RequestBody CharacterDto characterDto, UriComponentsBuilder componentsBuilder) {
        log.debug("create with {} - start ", characterDto);
        characterDtoValidator.validate(characterDto);
        var result = characterService.createCharacter(characterDto);
        return result.flatMap(character -> {
            URI uri = componentsBuilder.path("/api/v1/location/" + character.getId()).buildAndExpand(result).toUri();
            return Mono.just(ResponseEntity.created(uri).body(character));
        }).doOnSuccess(rs -> log.debug("create end with result {}", rs));
    }

    //GET
    @Override
    @Audit(AuditCode.CHARACTER_GET)
    public Mono<ResponseEntity<CharacterDto>> getCharacter(@PathVariable("id") UUID id) {
        log.debug("get with {} - start ", id);
        var result = characterService.getCharacter(id);
        return result
                .flatMap(character -> Mono.just(ResponseEntity.ok().body(character)))
                .doOnSuccess(character -> log.debug("get end with {}, with result {}", id, character));
    }

    //UPDATE
    @Override
    @Audit(AuditCode.CHARACTER_UPDATE)
    public Mono<ResponseEntity<CharacterDto>> updateCharacter(@RequestBody CharacterDto characterDto, @PathVariable("id") UUID id) {
        log.debug("update with {} - start", characterDto);
        if (!Objects.equals(id, characterDto.getId())) {
            throw new IllegalArgumentException("id= " + characterDto.getId() + ": expected same as " + id);
        }
        characterDtoValidator.validate(characterDto);
        var result = characterService.updateCharacter(characterDto);
        return result
                .flatMap(character -> Mono.just(ResponseEntity.ok().body(character)))
                .doOnSuccess(character -> log.debug("update with {} - end", character));
    }

    //delete
    @Override
    @Audit(AuditCode.CHARACTER_DELETE)
    public Mono<ResponseEntity> deleteCharacter(@PathVariable("id") UUID id) {
        log.debug("delete with {} - start ", id);
        var result = characterService.deleteCharacter(id);
        return result.flatMap(responseResult -> Mono.just(new ResponseEntity(HttpStatus.OK)))
                .doOnSuccess(character -> log.debug("delete with {} - end", id));
    }

    //данный метод нужен, тк я не подразумеваю удаление персонажей в моем приложении.
    @Override
    @Audit(AuditCode.CHARACTER_CHANGE_STATUS)
    public Mono<ResponseEntity> changeStatusCharacter(@RequestBody CharacterDto characterDto, @PathVariable("id") UUID id) {
        log.debug("change status with {} - start", characterDto);
        if (!Objects.equals(id, characterDto.getId())) {
            throw new IllegalArgumentException("id= " + characterDto.getId() + ": expected same as " + id);
        }
        characterDtoValidator.validate(characterDto);
        var result = characterService.changeStatusCharacter(id, characterDto);
        return result.flatMap(responseResult -> Mono.just(new ResponseEntity(HttpStatus.OK)))
                .doOnSuccess(characterId -> log.debug("delete with {} - end", id));
    }

    @Override
    public Flux<CharacterDto> getCharacters(@RequestBody Search<CharacterSearchDto> characterSearchDto) {
        log.debug("getCharacters with {} - start ", characterSearchDto);
        var result = characterService.getCharacters(characterSearchDto);
        log.debug("getCharacters end with {}, with result {}", characterSearchDto, result);
        return result;
    }
}
