package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import java.util.List;

public class Cart implements Identified {
    private long id;

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
