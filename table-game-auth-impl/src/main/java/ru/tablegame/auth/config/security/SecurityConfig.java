package ru.tablegame.auth.config.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import ru.tablegame.validate.service.TokenValidateService;

import java.util.List;

import static org.springframework.security.config.web.server.SecurityWebFiltersOrder.AUTHENTICATION;

/**
 * @author nemykin 21.03.2021
 */
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Slf4j
@AllArgsConstructor
public class SecurityConfig {

    private final TokenValidateService tokenValidateService;

    private final JwtService jwtService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http.httpBasic().disable()
                .addFilterAt(corsFilter(), SecurityWebFiltersOrder.FIRST)
                .formLogin().disable()
                .logout().disable()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers(
                        "/api/auth",
                        "/api/auth/**",
                        "/actuator/**",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/documentation/**",
                        "/swagger-ui.html",
                        "/swagger-ui/**"
                ).permitAll()
                .anyExchange().authenticated()
                .and()
                .addFilterAt(authenticationFilter(new TokenAuthenticationManager(tokenValidateService)),
                        AUTHENTICATION)
                .exceptionHandling()
                .and()
                .build();
    }

    /**
     *
     * @param reactiveAuthenticationManager
     * @return
     */
    public AuthenticationWebFilter authenticationFilter(ReactiveAuthenticationManager reactiveAuthenticationManager) {
        var authenticationWebFilter = new AuthenticationWebFilter(reactiveAuthenticationManager);
        authenticationWebFilter.setAuthenticationSuccessHandler(new TokenFilterAuthenticationSuccessHandler());
        authenticationWebFilter.setServerAuthenticationConverter(new ServerHttpBearerAuthenticationConverter(jwtService));
        return authenticationWebFilter;
    }

    /**
     *
     * @return
     */
    private CorsWebFilter corsFilter() {
        var source = new UrlBasedCorsConfigurationSource();
        var config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        if (!CollectionUtils.isEmpty(config.getAllowedOrigins()))
            source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
