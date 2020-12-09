package tablegame.service;

import tablegame.controller.dto.CharacterDto;
import tablegame.model.User;

import java.util.List;

/**
 * @author nemykin 09.12.2020
 */
public interface CharacterService {

    /**
     * добавить игру
     *
     * @param game  - название игры
     * @param users - пользователи для новой игры
     */
    void addCharacterCharacteristics(String game, List<User> users);

    /**
     * обновление списка пользователей
     *
     * @param game  - название игры
     * @param users - список пользователей
     * @return - возват карточки игры для клиента
     */
    CharacterDto updateUserToGame(String game, List<User> users);

    /**
     * удалить пользователей из игры по названию
     *
     * @param game  - название игры
     * @param users - список пользователей
     */
    void deleteUserToGame(String game, List<User> users);
}
