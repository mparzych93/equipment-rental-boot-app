package pl.coderslab.equipmentrentalbootapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.equipmentrentalbootapp.entity.Category;
import pl.coderslab.equipmentrentalbootapp.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
