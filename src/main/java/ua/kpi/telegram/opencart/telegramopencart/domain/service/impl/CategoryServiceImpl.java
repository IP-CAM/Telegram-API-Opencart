package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CategoryService;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category add(String name, String description) {
        return categoryRepository.save(new Category(name, description));
    }

    @Override
    public void remove(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void update(long categoryId, Category category) {
        long id = categoryRepository.findById(categoryId).getId();

        category.setId(id);

        categoryRepository.save(category);
    }

    @Override
    public Category getRootCategory() {
        return categoryRepository.findById(1L);
    }
}
