package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.TaxonomyUnitService;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.CategoryRepository;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.TaxonomyUnitRepository;

import java.util.List;

@Service
public class TaxonomyUnitServiceImpl implements TaxonomyUnitService {
    private final TaxonomyUnitRepository taxonomyUnitRepository;

    private final CategoryRepository categoryRepository;

    public TaxonomyUnitServiceImpl(TaxonomyUnitRepository taxonomyUnitRepository,
                                   CategoryRepository categoryRepository) {
        this.taxonomyUnitRepository = taxonomyUnitRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void changeCategory(String name, String categoryName) {
        TaxonomyUnit taxonomyUnit = taxonomyUnitRepository.findByName(name);
        Category category = categoryRepository.findByName(categoryName);

        taxonomyUnit.setParentCategory(category);

        taxonomyUnitRepository.save(category);
    }

    @Override
    public List<TaxonomyUnit> getAll() {
        return taxonomyUnitRepository.findAll();
    }

    @Override
    public List<TaxonomyUnit> getAllByCategory(String categoryName) {
        return null;
    }
}
