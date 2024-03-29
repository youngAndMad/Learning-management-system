package backend.userservice.service;

import backend.userservice.dto.SocialAccountLinkDTO;
import backend.userservice.dto.UserDTO;
import backend.userservice.model.User;

public interface UserService {

    User findById(Long id);

    void update(User updatedUser);

    User save(UserDTO dto);

    void delete(Long id);

    User addSocialLink(SocialAccountLinkDTO dto,Long userId);
}
