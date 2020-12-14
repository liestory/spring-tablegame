package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import ru.tablegame.model.User;

import java.util.List;

/**
 * объекты для юзера получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
public class GameDto {

    /**
     * id игры
     */
    private Long id;

    /**
     * название игры
     */
    private String gameName;

    /**
     * юзаеры в этой игре
     */
    private List<User> userNameList;

    public GameDto() {
    }

    public GameDto(Long id, String gameName, List<User> userNameList) {
        this.id = id;
        this.gameName = gameName;
        this.userNameList = userNameList;
    }
}
