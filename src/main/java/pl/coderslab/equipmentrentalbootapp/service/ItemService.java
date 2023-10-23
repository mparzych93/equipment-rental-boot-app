package pl.coderslab.equipmentrentalbootapp.service;

import pl.coderslab.equipmentrentalbootapp.entity.Item;

import java.util.List;

public interface ItemService {
    Item findById(Long id);
    List<Item> findAll();
    List<Item> findAllByUserId(Long id);
    void saveItem(Item item);
    void updateItem(Item item);
    void deleteItem(Item item);
    int countItemByUserId(Long id);
}
