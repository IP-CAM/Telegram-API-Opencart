package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import java.util.List;

public interface CustomerService {
    Customer register(String login, String phone);

    void addToCart(String login, String goods, long amount);

    void removeGoodsFromCart(String login, String goods);

    void reduceAmountOfGoods(String login, String goods, long amount);

    void clearCart(String login);

    void checkout(String login);

    List<Goods> getAllCustomerGoods();
}
