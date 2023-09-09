package backend.userservice.model;

import backend.userservice.utils.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.CustomEditorConfigurer;

import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String surname;

    @OneToMany(
            fetch = FetchType.EAGER
    )
    private Set<RoleEntity> roles;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "user"
    )
    private Set<SocialAccountLink> socialAccountLinks;

    public boolean canAssign(Role role) {
        return roles.stream().
                noneMatch(r -> r.getRole() == role);
    }

    public boolean depriveRole(Role role) {
        if (!canAssign(role)) {
            return false;
        }

        roles.removeIf(r -> r.getRole() == role);
        return true;
    }

}
