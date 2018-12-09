package ua.kpi.telegram.opencart.telegramopencart.domain.model;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import static org.junit.Assert.assertEquals;

public class CartTest {

    private Cart cart;

    private BuyItem buyItem1;

    private BuyItem buyItem2;

    private Goods goods1;

    private Goods goods2;

    @Before
    public void setUp() {
        goods1 = new Goods("TestGood1", "TestDesc1", 123);
        goods2 = new Goods("TestGood2", "TestDesc2", 123);

        buyItem1 = new BuyItem(goods1, 2);
        buyItem2 = new BuyItem(goods2, 3);

        cart = new Cart();

        cart.addToCart(buyItem1);
        cart.addToCart(buyItem2);
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
        cart.remove(buyItem1);

        assertEquals(buyItem2, cart.getBuyItems().get(0));
    }

    @Test
    public void shouldReturnOnlyBuyItem1AfterRemovingBuyItem2ByGoods() {
        cart.remove(goods2);

        assertEquals(buyItem1, cart.getBuyItems().get(0));
    }
}
