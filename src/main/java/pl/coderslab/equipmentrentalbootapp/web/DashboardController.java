package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;
import pl.coderslab.equipmentrentalbootapp.service.RentalService;

import java.util.List;

@Controller
public class DashboardController {
    private final RentalService rentalService;

    public DashboardController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @ModelAttribute("quantityOfItems")
    public int countItems(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return entityUser.getItems().size();
    }

    @ModelAttribute("quantityOfRentals")
    public int countRentals(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        return entityUser.getRentals().size();
    }

    @ModelAttribute("expiredRentals")
    public List<Rental> showExpiredRentals(@AuthenticationPrincipal CurrentUser customUser) {
        Long entityUserId = customUser.getUser().getId();
        List<Rental> expiredRentals = rentalService.findAllExpiredUserRentals(entityUserId);
        return rentalService.findAllExpiredUserRentals(entityUserId);
    }

    @ModelAttribute("expiredRentalsOfMyItems")
    public List<Rental> showExpiredRentalsOfMyItems(@AuthenticationPrincipal CurrentUser customUser) {
        Long entityUserId = customUser.getUser().getId();
        List<Rental> expiredRentalsOfMyItems = rentalService.findAllExpiredRentalsOfMyItems(entityUserId);
        expiredRentalsOfMyItems.stream().forEach(rental -> System.out.println(rental));
        return rentalService.findAllExpiredRentalsOfMyItems(entityUserId);
    }

    @GetMapping(value = "/app/dashboard")
    public String dashboard(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "/app/dashboard";
    }
}
