package pl.coderslab.equipmentrentalbootapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.equipmentrentalbootapp.entity.Item;
import pl.coderslab.equipmentrentalbootapp.repository.ItemRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findAllByUserId(Long id) {
        return itemRepository.findAllByUserId(id);
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public int countItemByUserId(Long id) {
        return itemRepository.countItemByUserId(id);
    }
}
