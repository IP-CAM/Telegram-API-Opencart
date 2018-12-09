package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import java.util.Collection;

public interface GoodsService {
    Goods update(Goods goods, Long id);

    Goods add(Goods goods);

    void remove(String name);

    Collection<Goods> getAll();
}
