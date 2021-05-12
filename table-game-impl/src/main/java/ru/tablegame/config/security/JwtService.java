package ru.tablegame.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author nemykin 08.04.2021
 */
@Slf4j
@Component
public class JwtService {

    public static final String BEARER_PREFIX = "bearer ";

    public Mono<String> resolveToken(ServerWebExchange serverWebExchange) {
        return Mono.justOrEmpty(resolveToken(serverWebExchange.getRequest()));
    }

    private String resolveToken(ServerHttpRequest request) {
        List<String> list = Optional.ofNullable(request.getHeaders())
                .map(httpHeaders -> httpHeaders.get(HttpHeaders.AUTHORIZATION))
                .orElse(new ArrayList<>());

        var token = list
                .stream()
                .filter(s -> s.toLowerCase().startsWith(BEARER_PREFIX))
                .findFirst()
                .orElse(null);
        if (token == null)
            return null;
        return token.substring(BEARER_PREFIX.length());
    }
}
