package tablegame.model;

/**
 * статусы пользователей на играх
 *
 * @author nemykin 14.10.2020
 */
public enum UserStatus {
    STATUS_ACTIVED("Активен"),
    STATUS_OBSERVER("Наблюдатель"),
    STATUS_LOCKED("Заблокирован");

    /**
     * словетное описание статуса пользователя на играх.
     */
    private String description;

    UserStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
