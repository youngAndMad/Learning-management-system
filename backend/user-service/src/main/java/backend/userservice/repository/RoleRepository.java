package backend.userservice.repository;

import backend.userservice.model.RoleEntity;
import backend.userservice.utils.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findRoleEntityByRole(Role role);
}