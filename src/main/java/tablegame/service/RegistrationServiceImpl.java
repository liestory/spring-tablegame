package tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.UserDto;
import tablegame.dao.UserDAO;
import tablegame.model.User;

import java.util.UUID;

/**
 * @author Asus 28.10.2020
 */
@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private UserDAO userDao;

    public RegistrationServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword());
        userDao.save(user);
        userDto.setId(user.getId());
        log.info("<== regUser:= {}", userDto);
        return userDto;
    }


}
