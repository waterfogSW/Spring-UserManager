package waterfogsw.user_manager.service;

import waterfogsw.user_manager.domain.User;
import waterfogsw.user_manager.repository.MemoryUserRepository;
import waterfogsw.user_manager.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository = new MemoryUserRepository();

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
}
