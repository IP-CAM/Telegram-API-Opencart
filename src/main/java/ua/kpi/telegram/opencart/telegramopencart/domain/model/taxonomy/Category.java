package ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy;

import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity
public class Category extends TaxonomyUnit {

    @OneToMany
    @Cascade(ALL)
    private List<TaxonomyUnit> taxonomyUnits = new ArrayList<>();

    public Category() {

    }

    public Category(String name, String description) {
        super(name, description);
    }

    public void addToCategory(List<TaxonomyUnit> taxonomyUnits) {
        for(TaxonomyUnit taxonomyUnit: taxonomyUnits) {
            addToCategory(taxonomyUnit);
        }
    }

    public void addToCategory(TaxonomyUnit taxonomyUnit) {
        taxonomyUnits.add(taxonomyUnit);
        taxonomyUnit.setParentCategory(this);
    }

    public List<TaxonomyUnit> getTaxonomyUnits() {
        return taxonomyUnits;
    }

    public void setTaxonomyUnits(List<TaxonomyUnit> taxonomyUnits) {
        this.taxonomyUnits = taxonomyUnits;
    }
}
