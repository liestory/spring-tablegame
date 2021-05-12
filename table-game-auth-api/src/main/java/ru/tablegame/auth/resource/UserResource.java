package ru.tablegame.auth.resource;

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
import ru.tablegame.auth.resource.dto.ResponseError;
import ru.tablegame.auth.resource.dto.Search;
import ru.tablegame.auth.resource.dto.user.UserDto;
import ru.tablegame.auth.resource.dto.user.UserSearchDto;

import java.util.UUID;

/**
 * @author nemykin 28.10.2020
 */
@RequestMapping("/api/v1/user")
@Api(value = "контроллер для работы с юзерами")
public interface UserResource {

    /**
     * блок CRUD
     */
    //create
    @PostMapping
    @ApiOperation(value = "создание юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка юзера",
                    response = UserDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity<UserDto>> createUser(@ApiParam(value = "карточка юзера", required = true) @RequestBody UserDto userDto,
                                             UriComponentsBuilder componentsBuilder);

    //GET
    @GetMapping("{id}")
    @ApiOperation(value = "получение юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка юзера",
                    response = UserDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity<UserDto>> getUser(@ApiParam(name = "id", value = "id юзера", required = true) @PathVariable("id") UUID id);

    //UPDATE
    @PutMapping("{id}")
    @ApiOperation(value = "обновление юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "карточка юзера",
                    response = UserDto.class, responseContainer = "ResponseEntity"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity> updateUser(@ApiParam(value = "карточка персонажа") @RequestBody UserDto userDto,
                                    @ApiParam(name = "id", value = "id юзера", required = true) @PathVariable("id") UUID id);

    //delete
    @DeleteMapping("{id}")
    @ApiOperation(value = "удаление юзера")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })
    Mono<ResponseEntity> deleteUser(@ApiParam(name = "id", value = "id юзера", required = true) @PathVariable("id") UUID id);

    @GetMapping
    @ApiOperation(value = "получение пагианционного списка юзеров")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "пагинационный список юзеров", response = UserDto.class, responseContainer = "PageDto"),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
            @ApiResponse(code = 404, message = "Юзер с указанным id не найден", response = ResponseError.class)
    })
    Flux<UserDto> getUsers(@ApiParam(value = "пагианционный список юзеров", required = true) @RequestBody Search<UserSearchDto> userSearchDto);
}
