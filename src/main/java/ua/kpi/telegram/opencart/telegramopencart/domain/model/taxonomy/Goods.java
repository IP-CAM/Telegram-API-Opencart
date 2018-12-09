package ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy;

import javax.persistence.Entity;

@Entity
public class Goods extends TaxonomyUnit {
    private long price;

    public Goods() {

    }

    public Goods(String name, String description, long price) {
        super(name, description);
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
