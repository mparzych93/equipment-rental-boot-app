package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.equipmentrentalbootapp.entity.Category;
import pl.coderslab.equipmentrentalbootapp.entity.Item;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.service.CategoryService;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;
import pl.coderslab.equipmentrentalbootapp.service.ItemService;
import pl.coderslab.equipmentrentalbootapp.service.RentalService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class ItemController {
    private final ItemService itemService;
    private final CategoryService categoryService;
    private final RentalService rentalService;

    public ItemController(ItemService itemService, CategoryService categoryService, RentalService rentalService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
        this.rentalService = rentalService;
    }

    @ModelAttribute("allItems")
    public Collection<Item> allItems() {
        Collection<Item> allItems = itemService.findAll();
        return allItems;
    }
    @ModelAttribute("userItems")
    public Collection<Item> myItems(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        Collection<Item> userItems = itemService.findAllByUserId(entityUser.getId());
        return userItems;
    }
    @ModelAttribute("categories")
    public Collection<Category> categories() {
        Collection<Category> categories = categoryService.findAll();
        return categories;
    }

    @ModelAttribute("rentals")
    public Collection<Rental> rentals() {
        Collection<Rental> rentals = rentalService.findAll();
        return rentals;
    }

    @GetMapping("/app/item/add")
    public String prepareForm(Model model) {
        model.addAttribute("item", new Item());
        return "app/addItem";
    }
    @PostMapping("/app/item/add")
    public String addItem(@AuthenticationPrincipal CurrentUser customUser, @Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "app/addItem";
        }
        User entityUser = customUser.getUser();
        item.setUser(entityUser);
        itemService.saveItem(item);
        return "redirect:/app/dashboard";
    }
    @GetMapping("/app/item/list")
    public String showAllItems() {
        return "app/allItems";
    }

    @GetMapping("/app/item/details/{id}")
    public String showItemDetails(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "app/itemDetails";
    }
    @GetMapping("/app/item/userlist")
    public String showUserItems() {
        return "app/userItems";
    }
    @GetMapping("/app/item/userItemDetails/{id}")
    public String showUserItemDetails(@PathVariable Long id, Model model) {
        model.addAttribute("userItem", itemService.findById(id));
        return "app/userItemDetails";
    }

    @GetMapping("/app/item/delete/{id}")
    public String prepareDeleteForm(@PathVariable Long id, Model model) {
        model.addAttribute("itemToDelete", itemService.findById(id));
        return "app/itemDeleteForm";
    }

    @PostMapping("/app/item/delete")
    public String deleteItem(@RequestParam String choice, @Valid @ModelAttribute("itemToDelete") Item itemToDelete, BindingResult result) {
        System.out.println(itemToDelete.getRentals());
        if ("ok".equals(choice)) {
            if (itemToDelete.getRentals().size() != 0) {
                result.addError(new FieldError("itemToDelete", "rentals", "The item is currently rented by someone"));
                return "app/itemDeleteForm";
            }
//            itemService.deleteItem(itemToDelete);
            return "redirect:/app/item/userlist";
        }
        return "redirect:/app/item/userlist";
    }

/*    @GetMapping("/app/item/edit/{id}")
    public String prepareEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("itemToEdit", itemService.findById(id));
        return "app/itemEditForm";
    }

    @Transactional
    @PostMapping("/app/item/edit")
    public String editItem(@Valid @ModelAttribute("itemToEdit") Item itemToEdit, BindingResult result) {
        System.out.println(itemToEdit);
        if (itemToEdit.getRental().getId() != null) {
            result.addError(new FieldError("itemToEdit", "rental.id", "The item is currently rented by someone"));
            return "app/itemEditForm";
        }
        itemService.updateItem(itemToEdit);
        return "redirect:/app/dashboard";
    }*/
}
