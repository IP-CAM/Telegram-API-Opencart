package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class BuyItem implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buyitem_id_sequence")
    @SequenceGenerator(name = "buyitem_id_sequence", sequenceName = "buyitem_id_sequence", allocationSize = 1)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private long amount;

    public BuyItem() {
    }

    public BuyItem(Goods goods, long amount) {
        this.goods = goods;
        this.amount = amount;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void addAmount(long amount) {
        this.amount += amount;
    }

    public void reduceAmount(long amount) {
        this.amount -= amount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyItem buyItem = (BuyItem) o;
        return id == buyItem.id &&
                amount == buyItem.amount &&
                goods.equals(buyItem.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goods, amount);
    }

    @Override
    public String toString() {
        return "BuyItem{" +
                "id=" + id +
                ", goods=" + goods +
                ", amount=" + amount +
                '}';
    }
}
