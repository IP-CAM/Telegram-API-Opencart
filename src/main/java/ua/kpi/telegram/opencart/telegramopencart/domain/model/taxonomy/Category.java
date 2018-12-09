package ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category extends TaxonomyUnit {

    @OneToMany
    private List<TaxonomyUnit> taxonomyUnits;

    public List<TaxonomyUnit> getTaxonomyUnits() {
        return taxonomyUnits;
    }

    public void setTaxonomyUnits(List<TaxonomyUnit> taxonomyUnits) {
        this.taxonomyUnits = taxonomyUnits;
    }


    public void addToCategory(List<TaxonomyUnit> taxonomyUnits) {
        this.taxonomyUnits.addAll(taxonomyUnits);
    }

    public void addToCategory(TaxonomyUnit taxonomyUnit) {
        taxonomyUnits.add(taxonomyUnit);
    }
}
