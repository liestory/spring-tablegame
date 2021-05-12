package ru.tablegame.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;

/**
 * @author nemykin 09.04.2021
 */
@Slf4j
public class TokenFilterAuthenticationSuccessHandler extends WebFilterChainServerAuthenticationSuccessHandler {

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        if (authentication instanceof TokenAuthentication) {
            var tokenAuthentication = ((TokenAuthentication) authentication);
            log.info("onAuthenticationSuccess for: {}", authentication.getName());
            return super.onAuthenticationSuccess(webFilterExchange, tokenAuthentication);

        }
        return super.onAuthenticationSuccess(webFilterExchange, authentication);
    }
}
