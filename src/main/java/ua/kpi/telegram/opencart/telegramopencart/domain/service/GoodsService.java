package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

public interface GoodsService {
    void addGoods(Goods goods);

    void removeGoods(String name);
}
