package ru.tablegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.tablegame.model.Character;

import java.util.UUID;

/**
 * репозиторий для работы с базой character
 *
 * @author nemykin 10.01.2021
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID>, JpaSpecificationExecutor<Character> {
}
