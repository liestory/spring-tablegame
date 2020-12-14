package ru.tablegame.model;

import java.util.AbstractMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author nemykin 14.10.2020
 */
public class User implements Identified<UUID> {

    private static final long serialVersionUID = 1896669364631244948L;

    /**
     * идентификатор пользователя
     */
    private UUID id;

    /**
     * логин пользователя
     */
    private String username;

    /**
     * пароль пользователя
     */
    private String password;

    /**
     * статус игрока
     * TODO: возможно тоже должен быть привязан к игре
     */
    private UserStatus userStatus;

    /**
     * роль игрока
     * ВАЖНО! роль у пользователя существует только в рамках игры.
     */
    private Map<Game, Role> role;

    /**
     * привязка персонажа к игре
     * ВАЖНО! персонажа у пользователя существует только в рамках игры.
     */
    private Map<Game, Character> characterGameMap;

    public User() {
        this.userStatus = UserStatus.STATUS_LOCKED;
    }

    public User(UUID id, String username, String password) {
        this();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Game, Role> getRole() {
        return role;
    }

    public void setRole(Map<Game, Role> role) {
        this.role = role;
    }

    public Map<Game, Character> getCharacterGameMap() {
        return characterGameMap;
    }

    public void setCharacterGameMap(Map<Game, Character> characterGameMap) {
        this.characterGameMap = characterGameMap;
    }
}
