package ru.tablegame.aspect.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.tablegame.aspect.model.AuditMessage;
import ru.tablegame.aspect.repository.AuditMessageRepository;

/**
 * @author nemykin 30.03.2021
 */
@Service
@Slf4j
@AllArgsConstructor
@ConditionalOnProperty(prefix = "audit", name = "service", havingValue = "db")
public class AuditServiceDBImpl implements AuditService {

    private AuditMessageRepository auditMessageRepository;

    @Override
    public void addAutidMessage(AuditMessage auditMessage) {
        auditMessageRepository.save(auditMessage);
    }
}
