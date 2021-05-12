package ru.tablegame.auth.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import ru.tablegame.auth.resource.dto.ResponseError;
import ru.tablegame.auth.resource.dto.user.AuthUserDto;
import ru.tablegame.auth.resource.dto.user.TokenDto;

/**
 * @author nemykin 19.03.2021
 */
@RequestMapping("/api/auth")
@Api(value = "контроллер для аутентификации")
public interface AuthResource {

    @PostMapping
    @ApiOperation(value = "Создание токена")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "токен юзера", response = TokenDto.class),
            @ApiResponse(code = 400, message = "Непредвиденная ошибка", response = ResponseError.class),
    })
    Mono<ResponseEntity<TokenDto>> createToken(@RequestBody AuthUserDto authUserDto);

}
