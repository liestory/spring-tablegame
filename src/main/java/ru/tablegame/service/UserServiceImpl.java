package ru.tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tablegame.controller.dto.UserDto;
import ru.tablegame.dao.UserDAO;
import ru.tablegame.model.Character;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;
import ru.tablegame.model.UserRoleAndStatus;
import ru.tablegame.model.UserStatus;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * @author Asus 14.10.2020
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        log.info("create user service");
        this.userDAO = userDAO;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct");
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword());
        userDAO.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    @Override
    public UserDto getUser(UUID id) {
        User user = userDAO.getByPK(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setStatus(user.getUserStatus().getDescription());
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userDAO.getByPK(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setUserStatus(UserStatus.getStatusByDesc(userDto.getStatus()));
        return userDto;
    }

    @Override
    public void deleteUser(UUID id) {
        userDAO.deleteByPK(id);
    }

    @Override
    public void addUser(User user) {
        log.info("now: " + LocalDateTime.now() + " UserService: " + this.toString());
        userDAO.save(user);
    }

    @Override
    public void addRole(User user, Role role, UserStatus status, Game game) {
        user.getUserRoleAndStatusList().add(new UserRoleAndStatus(new Random().nextLong(), status, role, game));
    }

    @Override
    public void changeRole(User user, Role role, UserStatus status, Game game) {
        for (UserRoleAndStatus userRoleAndStatus : user.getUserRoleAndStatusList()) {
            if (userRoleAndStatus.getGame().equals(game)) {
                userRoleAndStatus.setRole(role);
                userRoleAndStatus.setUserStatus(status);
            }
        }

    }

    @Override
    public void changeStatus(User user, UserStatus status) {
        user.setUserStatus(status);
    }

    @Override
    public void createCharacterByUser(User user, Game game) {
        Character character = new Character(game);
        user.getCharacterList().add(character);
    }
}
