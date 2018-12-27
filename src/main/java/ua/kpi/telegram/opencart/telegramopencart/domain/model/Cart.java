package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import org.hibernate.annotations.Cascade;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.hibernate.annotations.CascadeType.ALL;

@Entity
public class Cart implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    @JoinColumn(name = "cart_id")
    @Cascade(ALL)
    private List<BuyItem> buyItems = new ArrayList<>();

    public void addToCart(BuyItem buyItem) {
        buyItems.add(buyItem);
    }

    public void addToCart(List<BuyItem> buyItems) {
        this.buyItems.addAll(buyItems);
    }

    public void remove(BuyItem buyItem) {
        buyItems.remove(buyItem);
    }

    public void remove(Goods goods) {
        buyItems = buyItems.stream().filter(buyItem -> !buyItem.getGoods().equals(goods)).collect(toList());
    }

    public void clear() {
        buyItems.clear();
    }

    public boolean isEmpty() {
        return buyItems.isEmpty();
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<BuyItem> getBuyItems() {
        return buyItems;
    }

    public void setBuyItems(List<BuyItem> buyItems) {
        this.buyItems = buyItems;
    }

    public Optional<BuyItem> getBuyItemByGoods(Goods goods) {
        return buyItems.stream().filter(buyItem -> buyItem.getGoods().equals(goods)).findAny();
    }

    public boolean isGoodsPresentInCart(Goods goods) {
        return getGoods().contains(goods);
    }

    private List<Goods> getGoods() {
        return buyItems.stream()
                .map(BuyItem::getGoods)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", buyItems=" + buyItems +
                '}';
    }
}
