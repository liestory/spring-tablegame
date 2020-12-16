package ru.tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.tablegame.model.User;

import java.io.Serializable;
import java.util.List;

/**
 * объекты для юзера получаемые с контролеров
 *
 * @author nemykin 28.10.2020
 */
@Getter
@Setter
@ToString
public class GameDto implements Serializable {
    private static final long serialVersionUID = -619218161382592660L;

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

}
