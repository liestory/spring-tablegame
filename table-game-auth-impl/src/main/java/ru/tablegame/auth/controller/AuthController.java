package ru.tablegame.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.tablegame.aspect.annotation.Audit;
import ru.tablegame.aspect.annotation.AuditCode;
import ru.tablegame.auth.resource.AuthResource;
import ru.tablegame.auth.resource.dto.user.AuthUserDto;
import ru.tablegame.auth.resource.dto.user.TokenDto;
import ru.tablegame.auth.service.AuthService;

/**
 *
 *
 * @author nemykin 19.03.2021
 */
@RestController
@Slf4j
public class AuthController implements AuthResource {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    @Audit(AuditCode.AUTH_CREATE)
    public Mono<ResponseEntity<TokenDto>> createToken(AuthUserDto authUserDto) {
        log.debug("create with {} - start ", authUserDto);
        var result = authService.createToken(authUserDto);
        return result
                .flatMap(token -> Mono.just(ResponseEntity.ok().body(token)))
                .doOnSuccess(token -> log.debug("get end with {}", authUserDto));

    }
}
