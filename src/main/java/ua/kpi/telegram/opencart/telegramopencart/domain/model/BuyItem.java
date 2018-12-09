package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BuyItem implements Identified {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
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
}
