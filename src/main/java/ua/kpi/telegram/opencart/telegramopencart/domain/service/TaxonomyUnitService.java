package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;

import java.util.List;

public interface TaxonomyUnitService {
    void changeCategory(long taxonomyUnitId, long categoryId);

    List<TaxonomyUnit> getAll();

    List<TaxonomyUnit> getAllByCategory(String categoryName);
}
