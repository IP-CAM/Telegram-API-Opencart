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

    @PostMapping("/taxonomyunit/{name}")
    public void changeCategory(@PathVariable("name") String unitName,
                               @RequestParam("category") String categoryName) {
        taxonomyUnitService.changeCategory(unitName, categoryName);
    }

    @GetMapping("/taxonomyunit")
    public List<TaxonomyUnit> getAll() {
        return taxonomyUnitService.getAll();
    }

    @GetMapping("/taxonomyunit/{category}")
    public List<TaxonomyUnit> getAllByCategory(@PathVariable("category") String category) {
        return taxonomyUnitService.getAllByCategory(category);
    }
}
