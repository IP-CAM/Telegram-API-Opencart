package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;

public interface CategoryService {
    void add(Category category);

    void remove(String categoryName);
}
