package ru.tablegame.aspect.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.tablegame.aspect.annotation.AuditCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author nemykin 08.03.2021
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit")
public class AuditMessage implements Serializable {

    private static final long serialVersionUID = -1175727844595110895L;

    /**
     * Идентификатор события аудита.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    /**
     * Уникальный код события аудита
     */
    @Column(name = "audit_code")
    private AuditCode auditCode;

    /**
     * Тип события аудита: возможные значения START, SUCCESS, FAILURE
     */
    @Column(name = "audit_event")
    private AuditEvent auditEvent;

    /**
     * Время, соответствующее событию аудита START
     */
    @Column(name = "time_start")
    private LocalDateTime startTime;

    /**
     * Время, соответствующее событию аудита SUCCESS или FAILURE
     */
    @Column(name = "time_end")
    private LocalDateTime endTime;

    /**
     * Имя пользователя, от которого выполняется данный запрос
     */
    @Column(name = "user_name")
    private String userName = "";

    /**
     * Входящие параметры запроса в формате JSON
     */
    private String params;

    /**
     * Возвращаемое значение в результате выполнения метода в формате JSON
     */
    @Column(name = "return_value")
    private String result;

}
