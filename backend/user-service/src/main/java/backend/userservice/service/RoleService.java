package backend.userservice.service;

import backend.userservice.utils.Role;
import lombok.NonNull;

public interface RoleService {

    void assign(Long userId,@NonNull Role role);

    void deprive(Long userId, Role role);

}
