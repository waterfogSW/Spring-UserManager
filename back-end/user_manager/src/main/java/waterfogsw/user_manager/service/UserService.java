package waterfogsw.user_manager.service;

import java.util.List;
import java.util.Optional;

import waterfogsw.user_manager.domain.User;
import waterfogsw.user_manager.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 등록
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        userRepository.findByName(user.getName()).ifPresent(m -> {
            throw new IllegalStateException("User already exist!");
        });
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
