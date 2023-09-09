package backend.userservice.model;

import backend.userservice.utils.Role;
import jakarta.persistence.*;


@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;
}
