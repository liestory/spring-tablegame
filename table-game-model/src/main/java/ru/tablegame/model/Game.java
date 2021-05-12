package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * карточка игры
 *
 * @author nemykin 14.10.2020
 */
@Getter
@Setter
@ToString
@Table(schema = "tablegame", name = "game")
@Entity
public class Game extends CreateAtIdentified implements Identified<UUID> {
    private static final long serialVersionUID = -1222372107439913231L;

    /**
     * id игры
     */
    @Id
    @Column
    private UUID id;

    /**
     * имя игры
     */
    @Column(name = "game_name")
    private String gameName;

    /**
     * список юзеров в данной игре
     */
    @ElementCollection
    @Column(name = "user_name")
    private List<String> userNames;

    /**
     * состояние игры.
     */
    @Column(name = "game_status")
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;

    public Game() {
        this.gameStatus = GameStatus.CREATED;
    }

    public Game(UUID id) {
        this();
        this.id = id;
    }

    public Game(UUID id, String gameName) {
        this();
        this.id = id;
        this.gameName = gameName;
    }
}
