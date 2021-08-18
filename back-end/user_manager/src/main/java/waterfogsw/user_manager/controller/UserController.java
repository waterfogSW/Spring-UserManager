package waterfogsw.user_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    @GetMapping(value = "/")
}
