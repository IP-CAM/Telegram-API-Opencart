package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.TaxonomyUnitService;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.CategoryRepository;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.TaxonomyUnitRepository;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class TaxonomyUnitServiceImpl implements TaxonomyUnitService {

    private final Logger logger = getLogger(TaxonomyUnitServiceImpl.class);

    private final TaxonomyUnitRepository taxonomyUnitRepository;

    private final CategoryRepository categoryRepository;

    public TaxonomyUnitServiceImpl(TaxonomyUnitRepository taxonomyUnitRepository,
                                   CategoryRepository categoryRepository) {
        this.taxonomyUnitRepository = taxonomyUnitRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void changeCategory(String unitName, String categoryName) {
        TaxonomyUnit taxonomyUnit = taxonomyUnitRepository.findByName(unitName);
        Category category = categoryRepository.findByName(categoryName);

        logger.info("Changing " + unitName + "to Category with name " + categoryName);

        category.addToCategory(taxonomyUnit);

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
