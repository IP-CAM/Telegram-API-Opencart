package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.TaxonomyUnit;

import java.util.List;

@Repository
public interface TaxonomyUnitRepository extends JpaRepository<TaxonomyUnit, Long> {
    List<TaxonomyUnit> findByParentCategory(Category category);
}
