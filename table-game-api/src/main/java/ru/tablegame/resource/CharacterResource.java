package ru.tablegame.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.resource.dto.ResponseError;
import ru.tablegame.resource.dto.Search;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.resource.dto.character.CharacterSearchDto;

import java.util.UUID;

/**
 * @author nemykin 08.12.2020
 */
@RequestMapping("/api/v1/character")
@Api(value = "контроллер для работы с персонажами")
public interface CharacterResource {

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    @ApiOperation(value = "создание персонажа")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка созданного персонажа",
                    response = CharacterDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity<CharacterDto>> createCharacter(
            @ApiParam(value = "карточка персонажа", required = true) @RequestBody CharacterDto characterDto,
            UriComponentsBuilder componentsBuilder);

    //GET
    @GetMapping("{id}")
    @ApiOperation(value = "получение персонажа")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка персонажа",
                    response = CharacterDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Персонаж с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity<CharacterDto>> getCharacter(@ApiParam(name = "id", value = "id персонажа", required = true) @PathVariable("id") UUID id);

    //UPDATE
    @PutMapping("{id}")
    @ApiOperation(value = "обновление персонажа")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка персонажа",
                    response = CharacterDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Персонаж с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity<CharacterDto>> updateCharacter(@ApiParam(value = "карточка персонажа") @RequestBody CharacterDto characterDto,
                                                       @ApiParam(name = "id", value = "id персонажа", required = true) @PathVariable("id") UUID id);

    //delete
    @DeleteMapping("{id}")
    @ApiOperation(value = "удаление персонажа")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Персонаж с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity> deleteCharacter(@ApiParam(name = "id", value = "id персонажа", required = true) @PathVariable("id") UUID id);

    //данный метод нужен, тк я не подразумеваю удаление персонажей в моем приложении.
    @PostMapping("{id}/status")
    @ApiOperation(value = "изменение статуса персонажа")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Персонаж с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity> changeStatusCharacter(@ApiParam(value = "карточка персонажа", required = true) @RequestBody CharacterDto characterDto,
                                               @ApiParam(name = "id", value = "id персонажа", required = true) @PathVariable("id") UUID id);

    @GetMapping
    @ApiOperation(value = "получение пагианционного списка персонажей")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "пагинационный список персонажей", response = CharacterDto.class, responseContainer = "PageDto"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Персонаж с указанным id не найден", response = ResponseError.class)
    })
    Flux<CharacterDto> getCharacters(
            @ApiParam(value = "пагианционный список персонажей", required = true) @RequestBody Search<CharacterSearchDto> characterSearchDto);
}
