package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Entity
public class Cart implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id_sequence")
    @SequenceGenerator(name = "cart_id_sequence", sequenceName = "cart_id_sequence", allocationSize = 1)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cart")
    private List<BuyItem> buyItems = new ArrayList<>();

    public void addToCart(Goods goods, long amount) {
        if (isGoodsPresentInCart(goods)) {
            getBuyItemByGoods(goods).ifPresent(buyItem -> buyItem.addAmount(amount));
        } else {
            buyItems.add(new BuyItem(goods, amount));
        }
    }

    public boolean removeFromCart(Goods goods, long amount) {
        Optional<BuyItem> buyItemOptional = getBuyItemByGoods(goods);

        if (buyItemOptional.isPresent()) {
            BuyItem buyItem = buyItemOptional.get();

            if (buyItem.getAmount() > amount) {
                buyItem.reduceAmount(amount);
                return true;
            } else if (buyItem.getAmount() == amount) {
                return removeFromCart(goods);
            }
        }

        return false;
    }

    public boolean removeFromCart(Goods goods) {
        if (isGoodsPresentInCart(goods)) {
            this.buyItems.removeAll(buyItems.stream().filter(buyItem -> !buyItem.getGoods().equals(goods)).collect(toList()));
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        buyItems = new ArrayList<>();
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
