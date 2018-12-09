package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import javax.persistence.Entity;

@Entity
public class Goods extends TaxonomyUnit {
    private long price;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
