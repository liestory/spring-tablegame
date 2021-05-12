package ru.tablegame.auth.model;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * аудит по всем операциям.
 *
 * @author nemykin 16.01.2021
 */
@Slf4j
public class AuditingListener {

    /**
     * отметка о времени создания
     *
     * @param createAtIdentified - карточка изменений
     */
    @PrePersist
    public void prePersist(CreateAtIdentified createAtIdentified) {
        LocalDateTime localDateTime = LocalDateTime.now();
        createAtIdentified.setCreatedAt(localDateTime);
        createAtIdentified.setUpdatedAt(localDateTime);
        log.info("created at " + localDateTime);
    }

    /**
     * отметка о времени изменений
     *
     * @param createAtIdentified - карточка изменений
     */
    @PreUpdate
    public void preUpdate(CreateAtIdentified createAtIdentified) {
        LocalDateTime localDateTime = LocalDateTime.now();
        createAtIdentified.setUpdatedAt(localDateTime);
        log.info("updated at " + localDateTime);
    }
}
