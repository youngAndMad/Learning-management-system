package backend.userservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER(0L),
    ADMIN(1L),
    LECTURE(2L),
    MANAGER(3L);

    private final Long DB_ID;
}
