package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.TaxonomyUnitService;

import java.util.List;

@RestController
public class TaxonomyUnitController {
    private final TaxonomyUnitService taxonomyUnitService;

    public TaxonomyUnitController(TaxonomyUnitService taxonomyUnitService) {
        this.taxonomyUnitService = taxonomyUnitService;
    }

    @PostMapping("/taxonomyunit/{taxonomy_unit_id}")
    public void changeCategory(@PathVariable("taxonomy_unit_id") long taxonomyUnitId,
                               @RequestParam("categoryId") long categoryId) {
        taxonomyUnitService.changeCategory(taxonomyUnitId, categoryId);
    }

    @GetMapping("/taxonomyunit")
    public List<TaxonomyUnit> getAll() {
        return taxonomyUnitService.getAll();
    }

    @GetMapping("/taxonomyunit/{categoryId}")
    public List<TaxonomyUnit> getAllByCategory(@PathVariable("categoryId") long categoryId) {
        return taxonomyUnitService.getAllByCategory(categoryId);
    }
}
