package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.TaxonomyUnitService;

@RestController
public class TaxonomyUnitController {
    private final TaxonomyUnitService taxonomyUnitService;

    public TaxonomyUnitController(TaxonomyUnitService taxonomyUnitService) {
        this.taxonomyUnitService = taxonomyUnitService;
    }
}
