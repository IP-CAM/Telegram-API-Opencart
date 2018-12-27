package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import static org.junit.Assert.assertEquals;

public class CartTest {

    private static final int AMOUNT_TWO = 2;

    private static final int AMOUNT_THREE = 3;

    private Cart cart;

    private Goods goods1;

    private Goods goods2;

    @Before
    public void setUp() {
        goods1 = new Goods("TestGood1", "TestDesc1", 123);
        goods2 = new Goods("TestGood2", "TestDesc2", 123);

        cart = new Cart();

        cart.addToCart(goods1, AMOUNT_TWO);
        cart.addToCart(goods2, AMOUNT_THREE);
    }

    @Test
    public void shouldReturnZeroBuyItemsAfterClear() {
        cart.clear();

        assertEquals(0, cart.getBuyItems().size());
    }

    @Test
    public void shouldReturn2BuyItemsAfterClear() {
        assertEquals(2, cart.getBuyItems().size());
    }

    @Test
    public void shouldReturnOnlyBuyItem2AfterRemovingBuyItem1() {
        cart.removeFromCart(goods1, AMOUNT_TWO);

        assertEquals(new BuyItem(goods2, AMOUNT_THREE), cart.getBuyItems().get(0));
    }

    @Test
    public void shouldReturnOnlyBuyItem1AfterRemovingBuyItem2ByGoods() {
        cart.removeFromCart(goods2);

        assertEquals(new BuyItem(goods1, AMOUNT_TWO), cart.getBuyItems().get(0));
    }
}
