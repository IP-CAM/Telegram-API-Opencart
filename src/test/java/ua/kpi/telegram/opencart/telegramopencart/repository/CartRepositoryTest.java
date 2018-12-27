package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
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
        TEST_GOODS_1.setName("testGoods1");
        TEST_GOODS_2.setName("testGoods2");

        goodsRepository.saveAndFlush(TEST_GOODS_1);
        goodsRepository.saveAndFlush(TEST_GOODS_2);

        TEST_CART_1.addToCart(TEST_GOODS_1, 2);
        TEST_CART_1.addToCart(TEST_GOODS_2, 5);
        TEST_CART_2.addToCart(TEST_GOODS_2, 5);

        cartRepository.saveAndFlush(TEST_CART_1);
        cartRepository.saveAndFlush(TEST_CART_2);
    }

    @Test
    public void shouldReturnTestCart1OnFindingByTestGoods1() {
        assertEquals(singletonList(TEST_CART_1), cartRepository.findAllByBuyItems_Goods(TEST_GOODS_1));
    }

    @Test
    public void shouldReturnTestCart1AndTestCart2OnFindingByTestGoods2() {
        List<Cart> cartList = cartRepository.findAll();
        assertEquals(asList(TEST_CART_1, TEST_CART_2), cartRepository.findAllByBuyItems_Goods(TEST_GOODS_2));
    }
}