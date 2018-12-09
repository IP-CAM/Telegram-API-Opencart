package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

public interface GoodsService {
    Goods update(Goods goods, Long id);

    Goods addGoods(Goods goods);

    void removeGoods(String name);
}
