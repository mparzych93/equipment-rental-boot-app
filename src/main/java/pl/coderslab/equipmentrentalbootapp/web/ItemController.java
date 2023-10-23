package pl.coderslab.equipmentrentalbootapp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.equipmentrentalbootapp.entity.Category;
import pl.coderslab.equipmentrentalbootapp.entity.Item;
import pl.coderslab.equipmentrentalbootapp.entity.User;
import pl.coderslab.equipmentrentalbootapp.service.CategoryService;
import pl.coderslab.equipmentrentalbootapp.service.CurrentUser;
import pl.coderslab.equipmentrentalbootapp.service.ItemService;

import java.util.Collection;

@Controller
public class ItemController {
    private final ItemService itemService;
    private final CategoryService categoryService;

    public ItemController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
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

/*    @ModelAttribute("quantityOfUserItems")
    public int quantityOfUserItems(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return itemService.countItemByUserId(entityUser.getId());
    }*/
    @GetMapping("/app/item/add")
    public String prepareForm(Model model) {
        model.addAttribute("item", new Item());
        return "app/addItem";
    }
    @PostMapping("/app/item/add")
    public String addItem(@AuthenticationPrincipal CurrentUser customUser, Item item) {
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

    @PostMapping("/app/item/delete/{id}")
    public String deleteItem(@PathVariable Long id, @RequestParam String choice, Model model) {
        if ("ok".equals(choice)) {
            Item itemToDelete = itemService.findById(id);
            itemService.deleteItem(itemToDelete);
        }
        return "redirect:/app/dashboard";
    }

/*    @GetMapping("/app/item/edit/{id}")
    public String prepareEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "app/itemEditForm";
    }

    @PostMapping("/app/item/edit/{id}")
    public String editItem(@AuthenticationPrincipal CurrentUser customUser, Item item) {
        User entityUser = customUser.getUser();
        item.setUser(entityUser);
        itemService.updateItem(item);
        return "redirect:/app/dashboard";
    }*/
}
