package backend.userservice.dto;

import backend.userservice.utils.SocialAccountType;

public record SocialAccountLinkDTO(
        SocialAccountType type,
        String link
) {
}
