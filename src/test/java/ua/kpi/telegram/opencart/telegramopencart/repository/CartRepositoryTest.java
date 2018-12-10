package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    private static final Goods TEST_GOODS_1 = new Goods();

    private static final Goods TEST_GOODS_2 = new Goods();

    private static final Cart TEST_CART_1 = new Cart();

    private static final Cart TEST_CART_2 = new Cart();

    @Before
    public void setUp() {

        BuyItem testBuyItem1 = new BuyItem(TEST_GOODS_1, 2);
        BuyItem testBuyItem2 = new BuyItem(TEST_GOODS_2, 5);

        TEST_CART_1.addToCart(testBuyItem1);
        TEST_CART_1.addToCart(testBuyItem2);
        TEST_CART_2.addToCart(testBuyItem2);

        goodsRepository.save(TEST_GOODS_1);
        goodsRepository.save(TEST_GOODS_2);
        cartRepository.save(TEST_CART_1);
        cartRepository.save(TEST_CART_2);
    }

    @Test
    public void shouldReturnCart1AndCart2OnFindingByTestGoods2() {
        assertEquals(asList(TEST_CART_1, TEST_CART_2), cartRepository.findAllByBuyItems_Goods(TEST_GOODS_2));
    }

    @Test
    public void shouldReturnTestCart1OnFindingByTestGoods1() {
        assertEquals(Collections.singletonList(TEST_CART_1), cartRepository.findAllByBuyItems_Goods(TEST_GOODS_1));
    }
}