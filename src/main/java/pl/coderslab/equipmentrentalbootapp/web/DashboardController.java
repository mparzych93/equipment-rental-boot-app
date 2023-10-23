package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;

@Controller
public class DashboardController {
    @GetMapping(value = "/app/dashboard")
    public String dashboard(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "/app/dashboard";
    }
}
