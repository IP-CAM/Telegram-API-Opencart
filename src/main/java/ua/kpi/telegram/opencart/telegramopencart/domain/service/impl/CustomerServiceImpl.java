package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CustomerService;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;
import ua.kpi.telegram.opencart.telegramopencart.web.dto.CustomerDto;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
    public void register(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setId(customerDto.getId());
        customer.setUsername(customerDto.getUsername());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setBot(customerDto.isBot());
        customer.setLanguageCode(customerDto.getLanguageCode());
        customer.setRegisterDate(Instant.now());

        customerRepository.save(customer);
    }

    @Override
    public void addToCart(String username, String goodName, long amount) {
        Goods goods = goodsRepository.findByName(goodName);
        Customer customer = customerRepository.findCustomerByUsername(username);

        customer.getCart().addToCart(goods, amount);

        customerRepository.save(customer);
    }

    @Override
    public void removeFromCart(String username, String goodName, long amount) {
        Goods goods = goodsRepository.findByName(goodName);
        Customer customer = customerRepository.findCustomerByUsername(username);

        customer.getCart().removeFromCart(goods, amount);

        customerRepository.save(customer);
    }

    @Override
    public void removeGoodsFromCart(String username, String goodsName) {
        Customer customer = customerRepository.findCustomerByUsername(username);

        Goods goods = goodsRepository.findByName(goodsName);

        customer.getCart().removeFromCart(goods);

        customerRepository.save(customer);
    }

    @Override
    public void clearCart(String username) {
        Cart cart = customerRepository.findCustomerByUsername(username).getCart();

        cart.clear();
    }

    @Override
    public void checkout(String username) {
        Customer customer = customerRepository.findCustomerByUsername(username);

        customer.getCart().clear();

    }

    @Override
    public Cart getCart(String username) {
        return customerRepository.findCustomerByUsername(username).getCart();
    }

    @Override
    public List<Goods> getAllCustomerGoods(String login) {
        return getCart(login).getBuyItems()
                .stream()
                .map(BuyItem::getGoods)
                .collect(toList());
    }
}
