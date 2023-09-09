package backend.userservice.service;

import backend.userservice.dto.SocialAccountLinkDTO;
import backend.userservice.model.SocialAccountLink;
import backend.userservice.model.User;

public interface SocialAccountLinkService {
    SocialAccountLink save(SocialAccountLinkDTO dto, User user);

    void update(SocialAccountLink linkToUpdate);

    void delete(Long id);
}
