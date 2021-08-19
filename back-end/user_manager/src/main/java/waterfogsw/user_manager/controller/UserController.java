package waterfogsw.user_manager.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import waterfogsw.user_manager.domain.User;
import waterfogsw.user_manager.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userservice) {
        this.userService = userservice;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register/upload")
    public String create(UserForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setAge(form.getAge());
        user.setEmail(form.getEmail());
        
        userService.join(user);

        return "redirect:/";
    }

    @GetMapping("/users")
    public String list(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "userList";
    }
}
