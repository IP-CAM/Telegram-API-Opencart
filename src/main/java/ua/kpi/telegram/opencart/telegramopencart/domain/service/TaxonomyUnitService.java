package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;

public interface TaxonomyUnitService {
    void changeCategory(String name, Category category);
}
