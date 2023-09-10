package backend.userservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER(1L),
    ADMIN(2L),
    LECTURER(3L),
    MANAGER(4L);

    private final Long DB_ID;
}
