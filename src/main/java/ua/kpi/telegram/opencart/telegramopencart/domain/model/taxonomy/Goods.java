package ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy;

import javax.persistence.Entity;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return price == goods.price && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price + super.hashCode());
    }

    @Override
    public String toString() {
        return "Goods{" + super.toString() +
                "price=" + price +
                '}';
    }
}
