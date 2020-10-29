package tablegame.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tablegame.controller.dto.GameDto;
import tablegame.controller.dto.UserDto;
import tablegame.dao.GameDAO;
import tablegame.dao.UserDAO;
import tablegame.model.Game;
import tablegame.model.User;

import java.util.UUID;

/**
 * @author Asus 28.10.2020
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class.getName());
    private UserDAO userDao;

    public RegistrationServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto regUser(UserDto userDto) {
        User user = new User(UUID.randomUUID(), userDto.getUsername(), userDto.getPassword());
        userDao.save(user);
        userDto.setId(user.getId());
        return userDto;
    }


}
