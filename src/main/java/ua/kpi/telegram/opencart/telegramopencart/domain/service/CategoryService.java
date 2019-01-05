package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;

public interface CategoryService {
    Category add(String name, String description);

    void remove(long categoryId);

    void update(long categoryId, Category category);

    Category getRootCategory();
}
