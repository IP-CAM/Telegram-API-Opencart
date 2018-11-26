package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import java.util.List;

public class Category extends TaxonomyUnit {
    private long id;

    private List<TaxonomyUnit> taxonomyUnitList;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<TaxonomyUnit> getTaxonomyUnitList() {
        return taxonomyUnitList;
    }

    public void setTaxonomyUnitList(List<TaxonomyUnit> taxonomyUnitList) {
        this.taxonomyUnitList = taxonomyUnitList;
    }
}
