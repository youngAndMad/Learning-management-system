package backend.userservice.service.impl;

import backend.userservice.dto.UserDTO;
import backend.userservice.exception.EntityNotFoundException;
import backend.userservice.mapper.UserMapper;
import backend.userservice.model.User;
import backend.userservice.repository.UserRepository;
import backend.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
}
