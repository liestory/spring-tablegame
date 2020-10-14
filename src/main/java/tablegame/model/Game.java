package tablegame.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nemykin 14.10.2020
 */
public class Game implements Identified<Long> {
    private static final long serialVersionUID = -9005741475704378708L;

    private Long id;
    private String gameName;
    private Set<User> users;

    public Game() {
        this.users = new HashSet<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
