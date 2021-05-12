package ru.tablegame.aspect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tablegame.aspect.model.AuditMessage;

import java.util.UUID;

/**
 * @author nemykin 30.03.2021
 */
@Repository
public interface AuditMessageRepository extends JpaRepository<AuditMessage, UUID> {
}
