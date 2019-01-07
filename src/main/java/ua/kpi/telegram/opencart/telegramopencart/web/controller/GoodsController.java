package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.AuthorizationService;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.GoodsService;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
public class GoodsController {
    private static final int NOT_ACCESS_STATUS_CODE = 403;

    private final Logger logger = getLogger(GoodsController.class);

    private final AuthorizationService authorizationService;

    private final GoodsService goodsService;

    public GoodsController(AuthorizationService authorizationService, GoodsService goodsService) {
        this.authorizationService = authorizationService;
        this.goodsService = goodsService;
    }

    @GetMapping("/goods")
    public List<Goods> findAll() {
        logger.info("Finding all goods");
        return goodsService.getAll();
    }

    @GetMapping("/goods/category/{categoryId}")
    public List<Goods> findByCategory(@PathVariable("categoryId") long categoryId) {
        logger.info("Finding all goods by category");

        return goodsService.findAllByCategoryId(categoryId);
    }

    @GetMapping("/goods/{goodsId}")
    public Goods findById(@PathVariable("goodsId") long goodsId) {
        logger.info("Finding all goods by category");

        return goodsService.findById(goodsId);
    }

    @PutMapping("/goods")
    public ResponseEntity<Goods> createGoods(@RequestParam("authentication") String authentication,
                                             @RequestBody Goods goods) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            return ResponseEntity.ok(goodsService.add(goods));
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/goods")
    public ResponseEntity<Goods> updateGoods(@RequestParam("authentication") String authentication,
                                             @RequestBody Goods goods,
                                             @RequestParam("id") long goodsId) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            return ResponseEntity.ok(goodsService.update(goods, goodsId));
        } else {
            return ResponseEntity.status(NOT_ACCESS_STATUS_CODE).build();
        }
    }

    @DeleteMapping("/goods")
    public ResponseEntity deleteGoods(@RequestParam("authentication") String authentication,
                                      @RequestParam("id") long goodsId) {
        if (authorizationService.hasTaxonomyUnitChangeAccess(authentication)) {
            goodsService.remove(goodsId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(403).build();
        }
    }
}
