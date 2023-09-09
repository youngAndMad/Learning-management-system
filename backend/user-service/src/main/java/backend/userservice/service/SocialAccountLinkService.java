package backend.userservice.service;

import backend.userservice.dto.SocialAccountLinkDTO;
import backend.userservice.model.SocialAccountLink;
import backend.userservice.utils.SocialAccountType;

public interface SocialAccountLinkService {
    SocialAccountLink save(SocialAccountLinkDTO dto);
}
