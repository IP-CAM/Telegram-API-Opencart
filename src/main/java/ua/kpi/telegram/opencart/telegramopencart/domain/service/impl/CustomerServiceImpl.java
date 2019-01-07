package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.UserRole;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CustomerService;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;
import ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy.GoodsRepository;
import ua.kpi.telegram.opencart.telegramopencart.web.dto.CustomerDto;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static ua.kpi.telegram.opencart.telegramopencart.domain.model.UserRole.USER;

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
        customer.setUserRole(USER);

        customerRepository.save(customer);
    }

    @Override
    public void addToCart(long customerId, long goodsId, long amount) {
        Goods goods = goodsRepository.findById(goodsId);
        Customer customer = customerRepository.findById(customerId);

        customer.getCart().addToCart(goods, amount);

        customerRepository.save(customer);
    }

    @Override
    public void removeFromCart(long customerId, long goodsId, long amount) {
        Goods goods = goodsRepository.findById(goodsId);
        Customer customer = customerRepository.findById(customerId);

        customer.getCart().removeFromCart(goods, amount);

        customerRepository.save(customer);
    }

    @Override
    public void removeGoodsFromCart(long customerId, long goodsId) {
        Customer customer = customerRepository.findById(customerId);

        Goods goods = goodsRepository.findById(goodsId);

        customer.getCart().removeFromCart(goods);

        customerRepository.save(customer);
    }

    @Override
    public void clearCart(long customerId) {
        Cart cart = customerRepository.findById(customerId).getCart();

        cart.clear();
    }

    @Override
    public void checkout(long customerId) {
        Customer customer = customerRepository.findById(customerId);

        customer.getCart().clear();

    }

    @Override
    public Cart getCart(long customerId) {
        return customerRepository.findById(customerId).getCart();
    }

    @Override
    public List<Goods> getAllCustomerGoods(long customerId) {
        return getCart(customerId).getBuyItems()
                .stream()
                .map(BuyItem::getGoods)
                .collect(toList());
    }
}
