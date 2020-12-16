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

    //TODO: у меня вечная ошибка десеризации моего DTO
    // [DEBUG] 2020-12-16 17:27:13.802 [http-nio-8080-exec-2] RequestMappingHandlerMapping - Mapped to ru.tablegame.controller.GameController#gameRegistration(GameDto, UriComponentsBuilder)
    // [DEBUG] 2020-12-16 17:27:13.804 [http-nio-8080-exec-2] MappingJackson2HttpMessageConverter - Failed to evaluate Jackson deserialization for type [[simple type, class ru.tablegame.controller.dto.GameDto]
    // прошу подскажи как ее победить. В интернете только указано, что я должен десерилозвать объекты через доп класс
    // так же я поидее использую простые типы которые json понимает.

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
