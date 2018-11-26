package ua.kpi.telegram.opencart.telegramopencart.domain.model;

public class Good extends TaxonomyUnit {
    private long id;

    private long price;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
