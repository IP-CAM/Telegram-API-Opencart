package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cart implements Identified {
    @Id
    private long id;

    @OneToMany
    private List<BuyItem> buyItemList;

    public void addToCart(BuyItem buyItem) {
        buyItemList.add(buyItem);
    }

    public void addToCart(List<BuyItem> buyItems) {
        buyItemList.addAll(buyItems);
    }

    public void clearCart() {
        buyItemList.clear();
    }

    public void removeFromCart(BuyItem buyItem) {
        buyItemList.remove(buyItem);
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
