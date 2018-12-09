package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.GoodsService;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods update(Goods goods, Long id) {
        goods.setId(id);
        return goodsRepository.save(goods);
    }

    @Override
    public Goods add(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void remove(String name) {
        goodsRepository.deleteByName(name);
    }

    @Override
    public List<Goods> getAll() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> getAllByCategory(String categoryName) {
        return null;
    }
}
