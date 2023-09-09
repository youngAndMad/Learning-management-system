package backend.userservice.mapper;

import backend.userservice.dto.UserDTO;
import backend.userservice.model.RoleEntity;
import backend.userservice.model.User;
import backend.userservice.utils.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.HashSet;
import java.util.Set;

@Mapper
public interface UserMapper {

    @Mapping(target = "roles" , expression = "java(defaultRoles())")
    @Mapping(target = "id" , ignore = true)
    User toModel(UserDTO dto);

    default Set<RoleEntity> defaultRoles(){
        return new HashSet<>(Set.of(new RoleEntity(
                Role.USER.getDB_ID(), Role.USER
        )));
    }
}
