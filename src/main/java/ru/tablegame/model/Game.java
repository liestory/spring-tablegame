package ru.tablegame.model;

import java.util.List;

/**
 * карточка игры
 *
 * @author nemykin 14.10.2020
 */
public class Game implements Identified<Long> {
    private static final long serialVersionUID = -1222372107439913231L;

    /**
     * id игры
     */
    private Long id;

    /**
     * имя игры
     */
    private String gameName;

    /**
     * список юзеров в данной игре
     */
    private List<User> users;

    /**
     * состояние игры.
     */
    private GameStatus gameStatus;

    public Game() {
        this.gameStatus = GameStatus.CREATED;
    }

    public Game(Long id) {
        this();
        this.id = id;
    }

    public Game(Long id, String gameName) {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
