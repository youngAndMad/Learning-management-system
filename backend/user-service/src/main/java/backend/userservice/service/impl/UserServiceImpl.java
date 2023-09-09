package backend.userservice.service.impl;

import backend.userservice.dto.SocialAccountLinkDTO;
import backend.userservice.dto.UserDTO;
import backend.userservice.exception.EntityNotFoundException;
import backend.userservice.mapper.UserMapper;
import backend.userservice.model.User;
import backend.userservice.repository.UserRepository;
import backend.userservice.service.SocialAccountLinkService;
import backend.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SocialAccountLinkService socialAccountLinkService;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class));
    }

    @Override
    public void update(User updatedUser) {
        userRepository.save(updatedUser);
    }

    @Override
    public User save(UserDTO dto) {
        var model = userMapper.toModel(dto);

        return userRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(this.findById(id));
    }

    @Override
    public User addSocialLink(SocialAccountLinkDTO dto, Long userId) {
        var user = findById(userId);

        var optionalLink = user.getSocialAccountLinks().stream()
                .filter(l -> l.getType() == dto.type())
                .findFirst();

        if (optionalLink.isPresent()) {
            var link = optionalLink.get();
            link.setLink(dto.link());

            socialAccountLinkService.update(link);
        } else {
            var link = socialAccountLinkService.save(dto,user);
            user.getSocialAccountLinks().add(link);
            userRepository.save(user);
        }

        return user;
    }
}
