package tablegame.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author nemykin 29.10.2020
 */

@Getter
@Setter
public class ResponseError {
    private UUID id;
    private String message;
    private String codeError;
    private String systemId;

    public ResponseError(UUID id, String message, String codeError, String systemId) {
        this.id = id;
        this.message = message;
        this.codeError = codeError;
        this.systemId = systemId;
    }
}
