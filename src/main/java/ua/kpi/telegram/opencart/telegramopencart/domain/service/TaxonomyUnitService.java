package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;

import java.util.List;

public interface TaxonomyUnitService {
    void changeCategory(String name, String categoryName);

    List<TaxonomyUnit> getAll();
}
