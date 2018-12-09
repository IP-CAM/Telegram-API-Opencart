package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CustomerService;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void register(String login, String phone) {
        Customer customer = new Customer();

        customer.setLogin(login);
        customer.setPhone(phone);
        customer.setCart(new Cart());

        customerRepository.save(customer);
    }

    @Override
    public void addToCart(String login, BuyItem buyItem) {
        Customer customer = customerRepository.findCustomerByLogin(login);

        customer.getCart().addToCart(buyItem);

        customerRepository.save(customer);
    }

    public void removeFromCart(String login, BuyItem buyItem) {
        Customer customer = customerRepository.findCustomerByLogin(login);

        customer.getCart().removeFromCart(buyItem);

        customerRepository.save(customer);
    }
}
