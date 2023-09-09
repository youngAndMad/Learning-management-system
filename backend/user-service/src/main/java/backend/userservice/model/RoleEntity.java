package backend.userservice.model;

import backend.userservice.utils.Role;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role; // FIXME: 9/9/2023 add unique constraints during migration
}
