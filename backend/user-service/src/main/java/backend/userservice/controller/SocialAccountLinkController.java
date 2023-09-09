package backend.userservice.controller;

import backend.userservice.dto.SocialAccountLinkDTO;
import backend.userservice.service.SocialAccountLinkService;
import backend.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("social-account-link")
public class SocialAccountLinkController {

    private final UserService userService;
    private final SocialAccountLinkService linkService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(
            @PathVariable Long id
    ) {
        linkService.delete(id);
    }


    @PostMapping
    ResponseEntity<?> manage(
            @RequestParam("user_id") Long userId,
            @RequestBody SocialAccountLinkDTO dto
    ) {
        return ResponseEntity.ok(
                userService.addSocialLink(dto, userId)
        );
    }

}
