package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import java.util.List;

public interface GoodsService {
    Goods update(Goods goods, Long id);

    Goods add(Goods goods);

    void remove(long goodsId);

    List<Goods> getAll();

    Goods findById(long categoryId);

    List<Goods> findAllByCategoryId(long parentCategoryId);
}
