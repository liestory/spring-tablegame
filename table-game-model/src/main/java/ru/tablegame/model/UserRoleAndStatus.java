package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/**
 * карточка роли и статуса у юзер связанная с карточкой игр.
 *
 * @author nemykin 21.12.2020
 */
@Getter
@Setter
@ToString
@Entity
@Table(schema = "tablegame", name = "user_role_and_status")
public class UserRoleAndStatus extends CreateAtIdentified implements Identified<UUID> {

    private static final long serialVersionUID = 7114745593852976718L;
    /**
     * id карточки роли и статусу в юзера
     */
    @Id
    @Column
    @GeneratedValue
    private UUID id;

    /**
     * имя юзера
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * статус игрока
     */
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    /**
     * роль игрока
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * игра в рамках которой созданный роль и статус
     */
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

    public UserRoleAndStatus(UUID id, String userName, UserStatus userStatus, Role role, Game game) {
        this.id = id;
        this.userName = userName;
        this.userStatus = userStatus;
        this.role = role;
        this.game = game;
    }
}
