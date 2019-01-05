package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.web.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void register(CustomerDto customerDto);

    void addToCart(String login, String goods, long amount);

    void removeFromCart(String login, String goodName, long amount);

    void removeGoodsFromCart(String login, String goods);

    void clearCart(String login);

    void checkout(String login);

    Cart getCart(String login);

    List<Goods> getAllCustomerGoods(String login);
}
