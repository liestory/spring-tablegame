package ru.tablegame.auth.model;

import java.io.Serializable;

/**
 *  Interface of initialization objects
 * @param <PK>
 */
public interface Identified<PK extends Serializable> extends Serializable {

    /**
     * Возвращает идентификатор объекта
     *
     */
    PK getId();

}
