package ru.tablegame.validate.model;

import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Map;

/**
 * @author nemykin 21.03.2021
 */
public class MyAppClaims extends DefaultClaims {

    private static final String ROLE = "role";

    public MyAppClaims(Map<String, Object> map) {
        super(map);
    }

    public String getRole() {
        return get(ROLE, String.class);
    }

    public void setRole(String member) {
        setValue(ROLE, member);
    }

}
