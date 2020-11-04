package tablegame.controller.dto;

import java.util.UUID;

/**
 * @author nemykin 29.10.2020
 */
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCodeError() {
        return codeError;
    }

    public String getSystemId() {
        return systemId;
    }
}
