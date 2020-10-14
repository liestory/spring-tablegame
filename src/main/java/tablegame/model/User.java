package tablegame.model;

import java.util.UUID;

/**
 * @author nemykin 14.10.2020
 */
public class User implements Identified<UUID> {

    private static final long serialVersionUID = -7931737332645464539L;

    private UUID id;
    private String username;
    private UserStatus userStatus;
    private Role role;

    @Override
    public UUID getId() {
        return null;
    }
}
