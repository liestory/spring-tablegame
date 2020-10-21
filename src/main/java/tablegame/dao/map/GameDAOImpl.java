package tablegame.dao.map;

import org.springframework.stereotype.Repository;
import tablegame.dao.GameDAO;
import tablegame.model.Game;

import java.util.HashMap;

/**
 * @author Asus 14.10.2020
 */
@Repository
public class GameDAOImpl extends AbstractDao<Game, Long> implements GameDAO {
    public GameDAOImpl() {
        super(Game.class, new HashMap<>());
    }

    @Override
    public Game getByName(String gameName) {
        for (Game element : elements.values()) {
            if (element.getGameName().equals(gameName)) {
                return element;
            }
        }
        return null;
    }
}
