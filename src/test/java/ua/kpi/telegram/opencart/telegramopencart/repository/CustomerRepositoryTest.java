package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private static final String TEST_LOGIN = "TestLogin";

    private static final String TEST_PHONE = "+3801235454";

    private Customer savedCustomer = new Customer();

    @Before
    public void setUp() {
        savedCustomer.setLogin(TEST_LOGIN);
        savedCustomer.setPhone(TEST_PHONE);

        testEntityManager.persist(savedCustomer);
    }

    @Test
    public void shouldReturnCorrectCustomerOnFindingByLogin() {
        Customer customer = customerRepository.findCustomerByLogin(TEST_LOGIN);

        assertEquals(savedCustomer, customer);
    }

    @Test
    public void shouldReturnCorrectCustomerOnFindingByPhone() {
        Customer customer = customerRepository.findCustomerByPhone(TEST_PHONE);

        assertEquals(savedCustomer, customer);
    }
}
