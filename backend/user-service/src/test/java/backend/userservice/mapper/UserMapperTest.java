package backend.userservice.mapper;

import backend.userservice.dto.UserDTO;
import backend.userservice.utils.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    public void setup() {
        userMapper = Mappers.getMapper(UserMapper.class);
    }

    @Test
    public void toModelShouldBeValid() {
        var userDTO = new UserDTO("John", "Doe", "john.doe@example.com");

        var user = userMapper.toModel(userDTO);

        assertNotNull(user);
        assertEquals(1, user.getRoles().size());
        assertEquals(user.getName(), userDTO.name());
        assertEquals(user.getEmail(), userDTO.email());
        assertEquals(user.getSurname(), userDTO.surname());
        var roleEntity = user.getRoles().iterator().next();
        assertEquals(Role.USER, roleEntity.getRole());
    }
}