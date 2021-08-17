package waterfogsw.user_manager;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import waterfogsw.user_manager.domain.User;
import waterfogsw.user_manager.repository.MemoryUserRepository;

public class MemoryUserRepositoryTest {
    MemoryUserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("san kim");

        repository.save(user);

        User result = repository.findById(user.getId()).get();
        assertThat(result).isEqualTo(user);
    }

    @Test
    public void findByName() {
        User user = new User();
        user.setName("san kim");

        repository.save(user);
        
        User result = repository.findByName("san kim").get();
        assertThat(result).isEqualTo(user);
    }

    @Test
    public void findAll() {
        User user1 = new User();
        User user2 = new User();

        repository.save(user1);
        repository.save(user2);

        List<User> arrayList = repository.findAll();
        assertThat(arrayList.size()).isEqualTo(2);
    }
}
