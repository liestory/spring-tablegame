package ru.tablegame.auth.service;

import org.springframework.security.access.prepost.PreAuthorize;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.tablegame.auth.model.User;
import ru.tablegame.auth.resource.dto.Search;
import ru.tablegame.auth.resource.dto.user.UserDto;
import ru.tablegame.auth.resource.dto.user.UserSearchDto;

import java.util.UUID;

/**
 * сервис по работе с юзерами
 *
 * @author Asus 14.10.2020
 */
public interface UserService {

    /**
     * регистрация пользователя
     *
     * @param userDto - карточка пользователя с формы регистрации
     * @return
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT')")
    Mono<UserDto> regUser(UserDto userDto);

    /**
     * поиск пользователя
     *
     * @param id - id юзера в системе
     * @return - карточка юзера без паролей
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Mono<UserDto> getUser(UUID id);

    /**
     * обновление пользователя
     *
     * @param userDto - карточка юзера
     * @return - карточка юзера
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT')")
    Mono<UserDto> updateUser(UserDto userDto);

    /**
     * удаление пользователя
     * полноценного удаления нет, просто проставляем признат выключенности
     *
     * @param id - id юзера в системе
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    Mono<Void> deleteUser(UUID id);

    /**
     * добавить пользователя
     *
     * @param user - карточка юзера
     */
    void addUser(User user);

    /**
     * пагинационный поиск юзеров
     *
     * @param userSearchDto карточки юзеров для поиска
     * @return - пацинационный список юзеров
     */
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPPORT','ROLE_PLAYER')")
    Flux<UserDto> getUsers(Search<UserSearchDto> userSearchDto);
}
