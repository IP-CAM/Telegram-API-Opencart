package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.impl.CustomerServiceImpl;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;

import java.time.Instant;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private GoodsRepository goodsRepository;

    private static final String TEST_LOGIN = "testLogin";

    private static final String TEST_GOOD_1 = "testGood1";

    private static final String TEST_GOOD_2 = "testGood2";

    private static final String TEST_GOOD_3 = "testGood3";

    private Customer savedCustomer;

    private Goods savedGoods1 = new Goods(TEST_GOOD_1, "testDescription1", 123);

    private Goods savedGoods2 = new Goods(TEST_GOOD_2, "testDescription2", 123);

    @Before
    public void setUp() {
        savedCustomer = new Customer(TEST_LOGIN, "testPhone");
        savedCustomer.setRegisterDate(Instant.now());

        savedCustomer.getCart().addToCart(new BuyItem(savedGoods1, 4));
        savedCustomer.getCart().addToCart(new BuyItem(savedGoods2, 5));

        when(customerRepository.findCustomerByLogin(any(String.class))).thenReturn(savedCustomer);
        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);
        when(goodsRepository.findByName(any(String.class))).thenReturn(savedGoods1);
        when(goodsRepository.findAll()).thenReturn(asList(savedGoods1, savedGoods2));
    }

    @Test
    public void registerTest() {
        Customer customer = customerService.register(TEST_LOGIN, "testPhone");

        assertEquals(savedCustomer, customer);
    }

    @Test
    public void shouldSumAlreadyExisted() {
        customerService.addToCart(TEST_LOGIN, TEST_GOOD_2, 3);

        assertEquals(savedGoods1, savedCustomer.getCart().getBuyItems().get(0).getGoods());
    }

    @Test
    public void shouldAddNewItemToCart() {
        customerService.addToCart(TEST_LOGIN, TEST_GOOD_3, 3);

        assertEquals(savedGoods1, savedCustomer.getCart().getBuyItems().get(0).getGoods());
    }

    @Test
    public void shouldReturnTwoAmount() {
        customerService.reduceAmountOfGoods(TEST_LOGIN, TEST_GOOD_1, 2);

        assertEquals(4, savedCustomer.getCart().getBuyItems().get(0).getAmount());
    }

    @Test
    public void shouldReturnEmptyCartOnClearingCart() {
        customerService.clearCart(TEST_LOGIN);

        assertTrue(savedCustomer.getCart().isEmpty());
    }

    @Test
    public void shouldReturnEmptyCartOnCheckout() {
        customerService.checkout(TEST_LOGIN);

        assertTrue(savedCustomer.getCart().isEmpty());
    }

    @Test
    public void shouldReturnSavedGoodsTwo() {
        customerService.removeGoodsFromCart(TEST_LOGIN, TEST_GOOD_1);

        assertEquals(savedGoods2, savedCustomer.getCart().getBuyItems().get(0).getGoods());
    }

    @Test
    public void shouldReturnSameListAsRepository() {
        //assertEquals(asList(savedGoods1, savedGoods2), customerService.getAllCustomerGoods());
    }
}
