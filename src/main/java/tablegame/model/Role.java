package tablegame.model;

/**
 * роли в системе
 * ВАЖНО! роль не должна жить отдельно от игры, кроме роли ADMIN (cупер сользователь)
 *
 * @author nemykin 14.10.2020
 */
public enum Role {
    PLAYER,
    ADMIN_GAME,
    ADMIN

}
