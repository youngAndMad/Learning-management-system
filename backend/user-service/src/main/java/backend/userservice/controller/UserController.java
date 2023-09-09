package backend.userservice.controller;

import backend.userservice.dto.UserDTO;
import backend.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @RequestMapping("register")
    ResponseEntity<?> save(
            @RequestBody UserDTO dto
    ) {
        return ResponseEntity.status(201)
                .body(userService.save(dto));
    }

    @DeleteMapping("{id}")
    void delete(
            @PathVariable Long id
    ){
        userService.delete(id);
    }
}
