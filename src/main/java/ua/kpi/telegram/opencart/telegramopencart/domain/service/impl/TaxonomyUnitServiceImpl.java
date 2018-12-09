package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.TaxonomyUnitService;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.TaxonomyUnitRepository;

@Service
public class TaxonomyUnitServiceImpl implements TaxonomyUnitService {
    private final TaxonomyUnitRepository taxonomyUnitRepository;

    public TaxonomyUnitServiceImpl(TaxonomyUnitRepository taxonomyUnitRepository) {
        this.taxonomyUnitRepository = taxonomyUnitRepository;
    }

    @Override
    public void changeCategory(String name, Category category) {
        TaxonomyUnit taxonomyUnit = taxonomyUnitRepository.findByName(name);

        taxonomyUnit.setParentCategory(category);

        taxonomyUnitRepository.save(category);
    }
}
