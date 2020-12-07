package tablegame.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nemykin 14.10.2020
 */
@Getter
public class Game implements Identified<Long> {
    private static final long serialVersionUID = -9005741475704378708L;

    private Long id;
    private String gameName;
    private Set<User> users;
    private GameStatus gameStatus;

    public Game() {
        this.users = new HashSet<>();
        this.gameStatus = GameStatus.CREATED;
    }

    public Game(Long id, String gameName){
        this();
        this.id = id;
        this.gameName = gameName;
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

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
