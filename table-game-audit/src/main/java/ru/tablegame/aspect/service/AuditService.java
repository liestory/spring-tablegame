package ru.tablegame.aspect.service;

import ru.tablegame.aspect.model.AuditMessage;

/**
 * сервис для работы с событиями
 *
 * @author nemykin 30.03.2021
 */
public interface AuditService {

    /**
     * запись события
     *
     * @param auditMessage - карточка события
     */
    void addAutidMessage(AuditMessage auditMessage);
}
