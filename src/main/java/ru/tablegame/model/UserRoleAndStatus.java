package ru.tablegame.model;

import lombok.Getter;
import lombok.Setter;

/**
 * карточка роли и статуса у юзер связанная с карточкой игр.
 *
 * @author nemykin 21.12.2020
 */
@Getter
@Setter
public class UserRoleAndStatus {

    /**
     * id карточки роли и статусу в юзера
     */
    private Long id;

    /**
     * статус игрока
     */
    private UserStatus userStatus;

    /**
     * роль игрока
     */
    private Role role;

    /**
     * игра в рамках которой созданный роль и статус
     */
    private Game game;

    public UserRoleAndStatus(Long id, UserStatus userStatus, Role role, Game game) {
        this.id = id;
        this.userStatus = userStatus;
        this.role = role;
        this.game = game;
    }
}
