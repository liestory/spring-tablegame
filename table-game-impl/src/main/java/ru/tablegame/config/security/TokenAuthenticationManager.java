package ru.tablegame.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.tablegame.validate.model.MyAppClaims;
import ru.tablegame.validate.model.UserPrincipal;
import ru.tablegame.validate.service.TokenValidateService;

import java.util.Optional;

/**
 * @author nemykin 21.03.2021
 */
@Slf4j
@Service
public class TokenAuthenticationManager implements ReactiveAuthenticationManager {

    private TokenValidateService tokenValidateService;

    public TokenAuthenticationManager(TokenValidateService tokenValidateService) {
        this.tokenValidateService = tokenValidateService;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) throws AuthenticationException {
        return Mono.just(authentication)
                .map(auth -> {
                    String token = Optional.ofNullable(auth)
                            .map(a -> String.valueOf(a.getCredentials()))
                            .orElse(null);
                    if (token == null) {
                        authentication.setAuthenticated(false);
                        return authentication;
                    }
                    MyAppClaims myAppClaims = tokenValidateService.getAllClaimsFromToken(token);
                    tokenValidateService.validateToken(myAppClaims);
                    UserPrincipal.UserPrincipalBuilder user = UserPrincipal.username(myAppClaims.getSubject());
                    user.roles(myAppClaims.getRole())
                            .username(myAppClaims.getSubject())
                            .build();
                    UserDetails userDetails = user.build();
                    TokenAuthentication tokenAuthentication = new TokenAuthentication(token, userDetails);
                    tokenAuthentication.setAuthenticated(true);
                    return tokenAuthentication;
                });
    }
}
