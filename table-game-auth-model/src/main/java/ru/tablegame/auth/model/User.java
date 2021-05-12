package ru.tablegame.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author nemykin 14.10.2020
 */

@Getter
@Setter
@ToString
@Entity
@Table(schema = "auth", name = "user")
public class User extends CreateAtIdentified implements Identified<UUID> {

    private static final long serialVersionUID = 1896669364631244948L;

    /**
     * идентификатор пользователя
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * глобальная роль в системе
     */
    @Column(name = "roleGlobal")
    @Enumerated(EnumType.STRING)
    private RoleGlobal roleGlobal;

    /**
     * email юзера
     */
    private String email;

    /**
     * признак активности учетки
     * true     - учетка активна в системе
     * false    - учетка удалена
     */
    @Column(name = "active")
    private boolean activeUser;

    public User() {
        this.activeUser = false;
    }

    public User(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
