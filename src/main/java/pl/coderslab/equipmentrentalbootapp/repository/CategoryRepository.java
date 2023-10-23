package pl.coderslab.equipmentrentalbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.equipmentrentalbootapp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
