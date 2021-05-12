package ru.tablegame.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * абстрактный метод для проставления меток создания/обновления.
 *
 * @author nemykin 16.01.2021
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingListener.class)
@AllArgsConstructor
@NoArgsConstructor
public abstract class CreateAtIdentified {

    /**
     * время создание
     */
    LocalDateTime createdAt;

    /**
     * время обновление
     */
    LocalDateTime updatedAt;
}
