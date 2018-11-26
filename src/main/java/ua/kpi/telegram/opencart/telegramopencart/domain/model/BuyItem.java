package ua.kpi.telegram.opencart.telegramopencart.domain.model;

public class BuyItem extends TaxonomyUnit {
    private long id;

    private Good good;

    private long amount;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
