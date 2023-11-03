package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.equipmentrentalbootapp.service.UserService;
import pl.coderslab.equipmentrentalbootapp.entity.User;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String prepareForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result) {
        if (userService.findByUsername(user.getUserName()) != null) {
            result.addError(new FieldError("user", "userName", "login is not unique"));
        }
        if (userService.findByEmail(user.getEmail()) != null) {
            result.addError(new FieldError("user", "email", "email is not unique"));
        }
        if (result.hasErrors()) {
            return "registerForm";
        }
        userService.saveUser(user);
        return "redirect:/app/dashboard";
    }
}