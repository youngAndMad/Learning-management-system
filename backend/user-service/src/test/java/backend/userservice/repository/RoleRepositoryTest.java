package backend.userservice.repository;

import backend.userservice.model.RoleEntity;
import backend.userservice.utils.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleRepositoryTest {

    @Mock
    private RoleRepository roleRepository;

    private RoleEntity roleEntity;

    @BeforeEach
    public void setUp() {
        roleEntity = new RoleEntity(Role.USER.getDB_ID(), Role.USER);
    }

    @Test
    public void findRoleEntityByRoleShouldBeValid() {
        when(roleRepository.findRoleEntityByRole(Role.USER)).thenReturn(roleEntity);

        var returnedRoleEntity = roleRepository.findRoleEntityByRole(Role.USER);

        assertThat(returnedRoleEntity).isEqualTo(roleEntity);
    }

    @Test
    public void findRoleEntityByRoleShouldReturnNull() {
        when(roleRepository.findRoleEntityByRole(Role.MANAGER)).thenReturn(null);

        var returnedRoleEntity = roleRepository.findRoleEntityByRole(Role.MANAGER);

        assertThat(returnedRoleEntity).isNull();
    }

}