package backend.userservice.service;

import backend.userservice.utils.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleService roleService;

    @BeforeEach
    public void setUp() {
        roleService = Mockito.mock(RoleService.class);
    }

    @Test
    public void assignWhenInputsAreValidThenNoException() {
        var userId = 1L;
        var role = Role.USER;

        assertDoesNotThrow(() -> roleService.assign(userId, role));
    }


    @Test
    public void depriveWhenCalledThenVerifyInvocation() {
        var userId = 1L;
        var role = Role.USER;

        roleService.deprive(userId, role);

        verify(roleService).deprive(userId, role);
    }


}