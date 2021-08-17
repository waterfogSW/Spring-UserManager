package waterfogsw.user_manager.repository;

import java.util.List;
import java.util.Optional;

import waterfogsw.user_manager.domain.User;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
    List<User> findAll();
}