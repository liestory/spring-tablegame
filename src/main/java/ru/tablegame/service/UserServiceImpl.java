package ru.tablegame.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tablegame.controller.dto.CharacterDto;
import ru.tablegame.controller.dto.CharacteristicsDto;
import ru.tablegame.dao.UserDAO;
import ru.tablegame.model.Character;
import ru.tablegame.model.Game;
import ru.tablegame.model.Role;
import ru.tablegame.model.User;
import ru.tablegame.model.UserStatus;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void addUser(User user) {
        log.info("now: " + LocalDateTime.now() + " UserService: " + this.toString());
        userDAO.save(user);
    }

    @Override
    public void addRole(User user, Role role, Game game) {
        user.getRole().put(game, role);
    }

    @Override
    public void changeRole(User user, Role role, Game game) {
        for (Map.Entry<Game, Role> gameRoleEntry : user.getRole().entrySet()) {
            if (gameRoleEntry.getKey().equals(game.getGameName())) {
                gameRoleEntry.setValue(role);
            }
        }

    }

    @Override
    public void changeStatus(User user, UserStatus status) {
        user.setUserStatus(status);
    }

    @Override
    public void createCharacterByUser(User user, Game game) {
        Character character = new Character();
        user.getCharacterGameMap().put(game, character);
    }

    @Override
    public List<CharacterDto> getCharacterByUserNameAndGameName(String userName, String gameName) {
        Map<Game, Character> gameCharacterMap = userDAO.getCharacterByUserNameAndGameName(userName, gameName);
        List<CharacterDto> characterDtos = new ArrayList<>();
        for (Character character : gameCharacterMap.values()) {
            CharacterDto characterDto = new CharacterDto();
            characterDto.setId(character.getId());
            characterDto.setCharacterName(character.getCharacterName());
            characterDto.setGameName(gameName);
            characterDto.setLevel(character.getLevel());
            characterDto.setCharacteristicsDto(new CharacteristicsDto(
                    character.getCharacterName(),
                    character.getCharacteristics().getStrength(),
                    character.getCharacteristics().getDexterity(),
                    character.getCharacteristics().getConstitution(),
                    character.getCharacteristics().getIntelligent(),
                    character.getCharacteristics().getWisdom(),
                    character.getCharacteristics().getCharisma()
            ));
            characterDtos.add(characterDto);
        }
        return characterDtos;
    }

}
