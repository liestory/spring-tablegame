package ru.tablegame.auth.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author nemykin 21.03.2021
 */
public class TokenAuthentication implements Authentication {

    private String token;
    private boolean authenticated;
    private UserDetails principal;

    public TokenAuthentication(String token, UserDetails principal) {
        this.token = token;
        this.principal = principal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return principal.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        if (principal != null)
            return principal.getUsername();
        else
            return null;
    }

    public String getToken() {
        return token;
    }
}
