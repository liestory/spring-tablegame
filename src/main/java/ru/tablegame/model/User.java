package ru.tablegame.model;

import java.util.List;
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
     */
    private UserStatus userStatus;
    /**
     * списки ролей и статусов у пользователя
     */
    private List<UserRoleAndStatus> userRoleAndStatusList;

    /**
     * привязка персонажа к игре
     */
    private List<Character> characterList;

    public User() {
        this.userStatus = UserStatus.STATUS_LOCKED;
    }

    public User(UUID id, String username, String password) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public List<UserRoleAndStatus> getUserRoleAndStatusList() {
        return userRoleAndStatusList;
    }

    public void setUserRoleAndStatusList(List<UserRoleAndStatus> userRoleAndStatusList) {
        this.userRoleAndStatusList = userRoleAndStatusList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
