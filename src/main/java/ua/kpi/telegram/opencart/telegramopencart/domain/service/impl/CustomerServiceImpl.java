package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CustomerService;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;

import java.time.Instant;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final GoodsRepository goodsRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               GoodsRepository goodsRepository) {
        this.customerRepository = customerRepository;
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Customer register(String login, String phone) {
        Customer customer = new Customer();

        customer.setLogin(login);
        customer.setPhone(phone);
        customer.setRegisterDate(Instant.now());

        return customerRepository.save(customer);
    }

    @Override
    public void addToCart(String login, String goodName, long amount) {
        Goods goods = goodsRepository.findByName(goodName);
        Customer customer = customerRepository.findCustomerByLogin(login);

        BuyItem buyItem = new BuyItem(goods, amount);
        customer.getCart().addToCart(buyItem);

        customerRepository.save(customer);
    }

    @Override
    public void removeGoodsFromCart(String login, String goods) {

    }

    @Override
    public void reduceAmountOfGoods(String login, String goods, long amount) {

    }

    @Override
    public void clearCart(String login) {

    }

    @Override
    public void checkout(String login) {

    }

    @Override
    public List<Goods> getAllCustomerGoods() {
        return null;
    }
}
