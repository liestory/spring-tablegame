package ru.tablegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.tablegame.model.Game;

import java.util.UUID;

/**
 * репозиторий для работы с базой game
 *
 * @author nemykin 12.01.2021
 */
@Repository
public interface GameRepository extends JpaRepository<Game, UUID>, JpaSpecificationExecutor<Game> {

    Game findGameByGameName(String name);
}
