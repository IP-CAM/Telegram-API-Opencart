package ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;

import java.util.List;

@Repository
public interface TaxonomyUnitRepository extends JpaRepository<TaxonomyUnit, Long> {
    List<TaxonomyUnit> findAllByParentCategory(Category category);

    TaxonomyUnit findByName(String name);

    TaxonomyUnit findById(long id);
}
