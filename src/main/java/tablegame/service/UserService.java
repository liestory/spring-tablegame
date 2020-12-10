package tablegame.service;

import tablegame.controller.dto.CharacterDto;
import tablegame.model.Character;
import tablegame.model.Game;
import tablegame.model.Role;
import tablegame.model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Asus 14.10.2020
 */
public interface UserService {
    /**
     * добавить пользователя
     *
     * @param user
     */
    void addUser(User user);

    /**
     * добавить роль
     *
     * @param user
     */
    void addRole(User user, Role role, Game game);

    /**
     * получения карточки персонажа по id юзеру и названию игры
     *
     * @param userId   - id юзера
     * @param gameName - название игры
     * @return -  список карточек персонажа
     */
    List<CharacterDto> getCharacterByUserIdAndGameName(UUID userId, String gameName);
}
