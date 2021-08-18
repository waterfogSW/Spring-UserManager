package waterfogsw.user_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import waterfogsw.user_manager.service.UserService;
import waterfogsw.user_manager.domain.User;
import waterfogsw.user_manager.repository.MemoryUserRepository;

public class UserServiceTest {
    UserService userService;
    MemoryUserRepository userRepository;

    @BeforeEach
    public void beforeEach() {
        userRepository = new MemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @AfterEach
    public void afterEach() {
        userRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        User user = new User();
        user.setName("hello");

        Long saveId = userService.join(user);

        User findUser = userRepository.findById(saveId).get();
        assertEquals(findUser.getName(), user.getName());
    }

    @Test
    public void 중복회원확인() {
        User user1 = new User();
        User user2 = new User();

        user1.setName("spring");
        user2.setName("spring");

        userService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));

        assertThat(e.getMessage()).isEqualTo("User already exist!");
    }
}
