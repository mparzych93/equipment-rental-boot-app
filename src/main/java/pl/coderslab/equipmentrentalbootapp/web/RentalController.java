package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.equipmentrentalbootapp.entity.Item;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;
import pl.coderslab.equipmentrentalbootapp.service.ItemService;
import pl.coderslab.equipmentrentalbootapp.service.RentalService;

import java.util.Collection;

@Controller
public class RentalController {
    private final RentalService rentalService;
    private final ItemService itemService;

    public RentalController(RentalService rentalService, ItemService itemService) {
        this.rentalService = rentalService;
        this.itemService = itemService;
    }
    @ModelAttribute("userRentals")
    public Collection<Rental> myRentals(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        Collection<Rental> userRentals = rentalService.findAllByUserId(entityUser.getId());
        return userRentals;
    }
    @GetMapping("/app/rental/item/{id}")
    public String prepareForm(@PathVariable Long id, Model model) {
        Item entityItem = itemService.findById(id);
        Rental entityRental = new Rental(entityItem);
        model.addAttribute("entityRental", entityRental);
        System.out.println(entityRental);
        return "app/rentalForm";
    }

    @PostMapping("/app/rental/add")
    public String addRental(@AuthenticationPrincipal CurrentUser customUser, @ModelAttribute("entityRental") Rental entityRental) {
        User entityUser = customUser.getUser();
        entityRental.setUser(entityUser);
        rentalService.saveRental(entityRental);
        return "redirect:/app/dashboard";
    }

    @GetMapping("/app/rental/userlist")
    public String showAllUserRentals() {
        return "app/allUserRentals";
    }
}
