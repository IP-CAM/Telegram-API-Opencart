package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category extends TaxonomyUnit {

    @OneToMany
    private List<TaxonomyUnit> taxonomyUnitList;

    public List<TaxonomyUnit> getTaxonomyUnitList() {
        return taxonomyUnitList;
    }

    public void setTaxonomyUnitList(List<TaxonomyUnit> taxonomyUnitList) {
        this.taxonomyUnitList = taxonomyUnitList;
    }
}
