package ru.tablegame.config.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author nemykin 09.04.2021
 */
@AllArgsConstructor
public class ServerHttpBearerAuthenticationConverter implements ServerAuthenticationConverter {

    private JwtService jwtService;

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange)
                .flatMap(serverWebExchange -> jwtService.resolveToken(serverWebExchange))
                .flatMap(token -> Mono.justOrEmpty(new UsernamePasswordAuthenticationToken(token, token)));
    }
}