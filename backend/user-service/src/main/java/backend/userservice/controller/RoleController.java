package backend.userservice.controller;

import backend.userservice.service.RoleService;
import backend.userservice.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @PostMapping("assign")
    @ResponseStatus(OK)
    void assignRole(
            @RequestParam("user_id") Long userId,
            @RequestParam Role role
    ) {
        roleService.assign(userId, role);
    }

    @PostMapping("deprive")
    @ResponseStatus(OK)
    void depriveRole(
            @RequestParam("user_id") Long userId,
            @RequestParam Role role
    ) {
        roleService.deprive(userId, role);
    }


}
