package ua.kpi.telegram.opencart.telegramopencart.repository;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Goods;

public interface TaxonomyUnitRepository {
    Goods findByCategory(Category category);
}
