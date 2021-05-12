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
import ru.tablegame.resource.dto.game.GameDto;
import ru.tablegame.resource.dto.game.GameSearchDto;

import java.util.UUID;

/**
 * @author nemykin 09.12.2020
 */
@RequestMapping("/api/v1/game")
@Api(value = "контроллер для работы с играми")
public interface GameResource {

    /**
     * блок CRUD
     */
    @PostMapping()
    @ApiOperation(value = "создание игры")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка игры",
                    response = GameDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity<GameDto>> gameRegistration(@ApiParam(value = "карточка игры", required = true) @RequestBody GameDto gameDto,
                                                   UriComponentsBuilder componentsBuilder);

    //GET
    @GetMapping("{id}")
    @ApiOperation(value = "получение игры")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка игры",
                    response = GameDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity<GameDto>> getGame(@ApiParam(name = "id", value = "id игры", required = true) @PathVariable("id") UUID id);

    //UPDATE
    @PutMapping("{id}")
    @ApiOperation(value = "обновление игры")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка игры",
                    response = GameDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity<GameDto>> updateGame(@ApiParam(value = "карточка персонажа") @RequestBody GameDto gameDto,
                                             @ApiParam(name = "id", value = "id игры", required = true) @PathVariable("id") UUID id);

    //delete
    @DeleteMapping("{id}")
    @ApiOperation(value = "удаление игры")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity> deleteGame(@ApiParam(name = "id", value = "id игры", required = true) @PathVariable("id") UUID id);

    @GetMapping
    @ApiOperation(value = "получение пагианционного списка игр")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "пагинационный список игр", response = GameDto.class, responseContainer = "PageDto"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Flux<GameDto> getGames(@ApiParam(value = "пагианционный список персонажей", required = true) @RequestBody Search<GameSearchDto> gameSearchDto);
}
