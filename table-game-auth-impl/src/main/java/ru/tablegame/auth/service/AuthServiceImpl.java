package ru.tablegame.auth.service;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import ru.tablegame.auth.model.User;
import ru.tablegame.auth.repository.UserRepository;
import ru.tablegame.auth.resource.dto.user.AuthUserDto;
import ru.tablegame.auth.resource.dto.user.TokenDto;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.util.UUID.randomUUID;

/**
 * @author nemykin 19.03.2021
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    public static final String USER_NOT_FOUND = "Не найден пользователь с таким логином или паролем";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${spring.application.name}")
    private String systemName;

    @Value("${token.time}")
    private String tokenTime;

    @Value(value = "${token.key}")
    private String tokenKey;

    @Override
    public Mono<TokenDto> createToken(AuthUserDto authUserDto) {
        User user = userRepository.findUserByUsername(authUserDto.getUserName())
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException(USER_NOT_FOUND));
        if (passwordEncoder.encode(authUserDto.getPassword()).equals(user.getPassword())) {
            throw new AuthenticationCredentialsNotFoundException(USER_NOT_FOUND);
        }
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(tokenKey));
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId().toString());
        claims.put("role", user.getRoleGlobal());
        claims.put("email", user.getEmail());
        String jws = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(tokenTime)))
                .setAudience(systemName)
                .setIssuedAt(new Date())
                .setId(randomUUID().toString())
                .setIssuer(systemName)
                .addClaims(claims)
                .signWith(key).compact();
        return Mono.just(new TokenDto(jws));

    }
}
