package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.AuthorizationService;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.TaxonomyUnitService;

import java.util.List;

@RestController
public class TaxonomyUnitController {
    private final AuthorizationService authorizationService;

    private final TaxonomyUnitService taxonomyUnitService;

    public TaxonomyUnitController(AuthorizationService authorizationService, TaxonomyUnitService taxonomyUnitService) {
        this.authorizationService = authorizationService;
        this.taxonomyUnitService = taxonomyUnitService;
    }

    @PostMapping("/taxonomyunit/{taxonomy_unit_id}")
    public ResponseEntity changeCategory(@RequestParam("authentication") String authentication,
                                         @PathVariable("taxonomy_unit_id") long taxonomyUnitId,
                                         @RequestParam("categoryId") long categoryId) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            taxonomyUnitService.changeCategory(taxonomyUnitId, categoryId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
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
