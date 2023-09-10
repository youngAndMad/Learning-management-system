package backend.userservice.service.impl;

import backend.userservice.model.RoleEntity;
import backend.userservice.repository.RoleRepository;
import backend.userservice.service.RoleService;
import backend.userservice.service.UserService;
import backend.userservice.utils.Role;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @Override
    public void assign(Long userId,@NonNull Role role) {
        var user = userService.findById(userId);

        if (!user.canAssign(role)) {
            return;
        }

        var roleToAssign = findByRole(role);
        user.getRoles().add(roleToAssign);
        userService.update(user);
    }

    @Override
    public void deprive(Long userId, Role role) {
        var user = userService.findById(userId);

        if (user.depriveRole(role)){
            userService.update(user);
        }
    }

    private RoleEntity findByRole(Role role) {
        return roleRepository
                .findRoleEntityByRole(role);
    }
}
