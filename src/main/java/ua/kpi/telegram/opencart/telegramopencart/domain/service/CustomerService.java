package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;

public interface CustomerService {
    void register(String login, String phone);

    void addToCart(String login, BuyItem buyItem);
}
