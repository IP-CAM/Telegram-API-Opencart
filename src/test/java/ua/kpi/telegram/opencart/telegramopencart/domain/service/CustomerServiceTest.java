package ua.kpi.telegram.opencart.telegramopencart.domain.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.impl.CustomerServiceImpl;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer savedCustomer;

    @Before
    public void setUp() {
        savedCustomer = new Customer("testLogin", "testPhone");
        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);
    }

    @Test
    public void registerTest() {
        Customer customer = customerService.register("testLogin", "testPhone");

        assertEquals(savedCustomer, customer);
    }
}
