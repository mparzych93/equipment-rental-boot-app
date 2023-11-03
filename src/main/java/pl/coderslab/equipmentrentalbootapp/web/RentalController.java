package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.equipmentrentalbootapp.dto.RentalDto;
import pl.coderslab.equipmentrentalbootapp.entity.Item;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;
import pl.coderslab.equipmentrentalbootapp.service.ItemService;
import pl.coderslab.equipmentrentalbootapp.service.RentalService;

import javax.validation.Valid;
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
    public String addRental(@AuthenticationPrincipal CurrentUser customUser, @Valid @ModelAttribute("entityRental") Rental entityRental, BindingResult result) {
        if (entityRental.getItem().getUser().getId() == customUser.getUser().getId()) {
            result.addError(new FieldError("entityRental", "item.user.id", "You cannot rent your item"));
            return "app/rentalForm";
        }
        if (rentalService.findByItemId(entityRental.getItem().getId()) != null) {
            result.addError(new FieldError("entityRental", "item.id", "the item is currently rented by someone"));
            return "app/rentalForm";
        }
        if (entityRental.getRentalDays() < entityRental.getItem().getMinimumRentalPeriodInDays()) {
            result.addError(new FieldError("entityRental", "rentalDays", "You must rent the item for at least the number of days specified by the issuer of the item"));
            return "app/rentalForm";
        }
        User entityUser = customUser.getUser();
        entityRental.setUser(entityUser);
        rentalService.saveRental(entityRental);
        return "redirect:/app/dashboard";
    }

    @GetMapping("/app/rental/delete/{id}")
    public String prepareDeleteForm(@PathVariable Long id, Model model) {
        Rental entityRental = rentalService.findById(id);
        RentalDto rentalDto = rentalService.convert(entityRental);
        model.addAttribute("rentalDto", rentalDto);
        return "app/rentalDeleteForm";
    }
    @PostMapping("/app/rental/delete")
    public String deleteItem(@RequestParam String choice, @Valid @ModelAttribute("rentalDto") RentalDto rentalDto, BindingResult result) {
        if ("ok".equals(choice)) {
            if (rentalDto.getDaysOnLoan() < rentalDto.getRentalDays()) {
                result.addError(new FieldError("rentalDto", "daysOnLoan", "The item is not on loan for at least the number of days you rented it for."));
                return "app/rentalDeleteForm";
            }
            rentalService.deleteRental(rentalService.findById(rentalDto.getRentalId()));
            return "redirect:/app/rental/userlist";
        }
        return "redirect:/app/rental/userlist";
    }

    @GetMapping("/app/rental/userlist")
    public String showAllUserRentals() {
        return "app/allUserRentals";
    }
}
