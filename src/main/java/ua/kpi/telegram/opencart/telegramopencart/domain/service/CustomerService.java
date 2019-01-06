package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.web.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void register(CustomerDto customerDto);

    void addToCart(long customerId, long goodsId, long amount);

    void removeFromCart(long customerId, long goodsId, long amount);

    void removeGoodsFromCart(long customerId, long goodsId);

    void clearCart(long customerId);

    void checkout(long customerId);

    Cart getCart(long customerId);

    List<Goods> getAllCustomerGoods(long customerId);
}
