package ru.tablegame.validate.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;
import ru.tablegame.validate.model.MyAppClaims;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.function.Function;

/**
 * @author nemykin 20.03.2021
 */
@Service
public class TokenValidateServiceImpl implements TokenValidateService {

    @Value("${spring.application.name}")
    private String systemName;

    @Value("${token.key}")
    private String tokenKey;

    @Override
    public String validateToken(String token) {
        return null;
    }

    @Override
    public void validateToken(MyAppClaims claims) {
        if (isTokenExpired(claims)) {
            throw new CredentialsExpiredException("Истек срок действия токена");
        }
        if (!isAud(claims)) {
            throw new AccountExpiredException("Не прав доступа на данную систему");
        }
    }

    @Override
    public MyAppClaims getAllClaimsFromToken(String token) {
        Key key = new SecretKeySpec(Decoders.BASE64.decode(tokenKey), SignatureAlgorithm.HS256.getJcaName());
        try {
            return new MyAppClaims(Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody());
        } catch (IllegalArgumentException e) {
            throw new AuthenticationServiceException("Произошла ошибка при получении полей токена");
        } catch (ExpiredJwtException e) {
            throw new AccountExpiredException("Tокен истек и больше не действителен");
        }
    }

    private Boolean isTokenExpired(MyAppClaims claims) {
        final Date expiration = getExpirationDateFromClaims(claims);
        return expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().isBefore(LocalDateTime.now());
    }

    private Date getExpirationDateFromClaims(MyAppClaims claims) {
        return getClaim(claims, Claims::getExpiration);
    }

    private <T> T getClaim(MyAppClaims claims, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(claims);
    }

    /**
     * @param claims
     * @return
     */
    private boolean isAud(MyAppClaims claims) {
        return getClaim(claims, Claims::getAudience).equals(systemName) ? true : false;
    }

}
