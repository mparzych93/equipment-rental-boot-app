package pl.coderslab.equipmentrentalbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.equipmentrentalbootapp.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findById(Long id);
    List<Item> findAllByUserId(Long id);
    int countItemByUserId(Long id);
}
