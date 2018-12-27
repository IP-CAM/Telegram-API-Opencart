package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    TestEntityManager testEntityManager;

    private static Goods TEST_GOODS_1;

    private static Goods TEST_GOODS_2;

    private static Cart TEST_CART_1;

    private static Cart TEST_CART_2;

    @Before
    public void setUp() {
        TEST_GOODS_1 = new Goods();
        TEST_GOODS_2 = new Goods();

        TEST_CART_1 = new Cart();
        TEST_CART_2 = new Cart();

        TEST_GOODS_1.setName("testGoods1");
        TEST_GOODS_1.setPrice(10);
        TEST_GOODS_2.setName("testGoods2");
        TEST_GOODS_2.setPrice(12);

        testEntityManager.persist(TEST_GOODS_1);
        testEntityManager.persist(TEST_GOODS_2);

        testEntityManager.persist(TEST_CART_1);
        testEntityManager.persist(TEST_CART_2);

        TEST_CART_1.addToCart(TEST_GOODS_1, 2);
        TEST_CART_1.addToCart(TEST_GOODS_2, 5);
        TEST_CART_2.addToCart(TEST_GOODS_2, 5);
    }

    @Test
    public void shouldReturnTestCart1OnFindingByTestGoods1() {
        assertEquals(singletonList(TEST_CART_1), cartRepository.findAllByBuyItems_Goods(TEST_GOODS_1));
    }

    @Test
    public void shouldReturnTestCart1AndTestCart2OnFindingByTestGoods2() {
        assertEquals(asList(TEST_CART_1, TEST_CART_2), cartRepository.findAllByBuyItems_Goods(TEST_GOODS_2));
    }
}