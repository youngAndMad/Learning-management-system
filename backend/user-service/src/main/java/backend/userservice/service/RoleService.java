package backend.userservice.service;

import backend.userservice.utils.Role;

public interface RoleService {

    void assign(Long userId, Role role);

    void deprive(Long userId, Role role);

}
