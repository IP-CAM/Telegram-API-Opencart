package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;

import java.util.List;

public interface TaxonomyUnitService {
    void changeCategory(String unitName, String categoryName);

    List<TaxonomyUnit> getAll();

    List<TaxonomyUnit> getAllByCategory(String categoryName);
}
