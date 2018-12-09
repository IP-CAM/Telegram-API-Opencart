package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;

public interface CustomerService {
    Customer register(String login, String phone);

    void addToCart(String login, String goods, long amount);

    void removeGoodsFromCart(String login, String goods);

    void reduceAmountOfGoods(String login, String goods, long amount);

    void clearCart(String login);

    void checkout(String login);
}
