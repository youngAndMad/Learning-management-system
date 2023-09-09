package backend.userservice.service;

import backend.userservice.model.User;

public interface UserService {
    User findById(Long id);

    void update(User updatedUser);
}
