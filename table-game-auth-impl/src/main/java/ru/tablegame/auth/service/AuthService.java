package ru.tablegame.auth.service;

import reactor.core.publisher.Mono;
import ru.tablegame.auth.resource.dto.user.AuthUserDto;
import ru.tablegame.auth.resource.dto.user.TokenDto;

/**
 * @author nemykin 19.03.2021
 */
public interface AuthService {

    /**
     * создание токена при аутентификации
     *
     * @param authUserDto
     * @return
     */
    Mono<TokenDto> createToken(AuthUserDto authUserDto);
}
