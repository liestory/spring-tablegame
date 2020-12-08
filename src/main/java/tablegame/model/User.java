package tablegame.model;

import java.util.Map;
import java.util.UUID;

/**
 * @author nemykin 14.10.2020
 */
public class User implements Identified<UUID> {

    private static final long serialVersionUID = -7931737332645464539L;

    private UUID id;
    private String username;
    private String password;
    private UserStatus userStatus;
    private Role role;
    private Map<Character, Game> characterGameMap;

    public User() {
        this.role = Role.PLAYER;
        this.userStatus = UserStatus.STATUS_ACTIVED;
    }

    public User(UUID id, String username, String password) {
        this();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public UUID getId() {
        return null;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Map<Character, Game> getCharacterGameMap() {
        return characterGameMap;
    }

    public void setCharacterGameMap(Map<Character, Game> characterGameMap) {
        this.characterGameMap = characterGameMap;
    }
}
