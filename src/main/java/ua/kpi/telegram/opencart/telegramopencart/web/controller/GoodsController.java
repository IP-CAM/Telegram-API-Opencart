package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.GoodsService;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class GoodsController {
    private final Logger logger = getLogger(GoodsController.class);

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/goods")
    public List<Goods> findAll() {
        logger.info("Finding all goods");
        return goodsService.getAll();
    }

    @GetMapping("/goods/{category}")
    public List<Goods> findByCategory(@PathVariable("category") String category) {
        logger.info("Finding all goods by category");
        return goodsService.getAllByCategory(category);
    }
}
