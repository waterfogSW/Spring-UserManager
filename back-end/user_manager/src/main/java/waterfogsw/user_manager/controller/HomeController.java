package waterfogsw.user_manager.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import waterfogsw.user_manager.domain.User;
import waterfogsw.user_manager.service.UserService;

@Controller
public class HomeController {
    private final UserService userService;
    
    @Autowired
    public HomeController(UserService userservice) {
        this.userService = userservice;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "home";
    }
}
