package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.dto.UserToEditDataDto;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;
import pl.coderslab.equipmentrentalbootapp.service.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class UserDataController {
    private final UserService userService;

    public UserDataController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/app/edit/userData")
    public String prepareFormToChangeUserData(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User loggedUser = customUser.getUser();
        UserToEditDataDto userToEditDataDto = userService.convert(loggedUser);
        model.addAttribute("userToEditDataDto", userToEditDataDto);
        return "app/editUserDataForm";
    }

    @Transactional
    @PostMapping("/app/edit/userData")
    public String editUserData(@AuthenticationPrincipal CurrentUser customUser, @Valid @ModelAttribute UserToEditDataDto userToEditDataDto, BindingResult result) {
        if (result.hasErrors()) {
            return "app/editUserDataForm";
        }
        User userToEdit = customUser.getUser();
        userToEdit.setFirstName(userToEditDataDto.getFirstName());
        userToEdit.setLastName(userToEditDataDto.getLastName());
        userToEdit.setAddress(userToEditDataDto.getAddress());
        userService.updateUser(userToEdit);
        return "redirect:/app/dashboard";
    }

    @GetMapping("/app/edit/password")
    public String prepareFormToChangePassword(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User loggedUser = customUser.getUser();
        model.addAttribute("userToEditPassword", loggedUser);
        return "app/editPasswordForm";
    }
}
