package ru.tablegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.tablegame.auth.model.User;

import java.util.UUID;

/**
 * репозиторий для работы с базой user
 *
 * @author nemykin 10.01.2021
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {

    User findUserByUsername(String name);
}
