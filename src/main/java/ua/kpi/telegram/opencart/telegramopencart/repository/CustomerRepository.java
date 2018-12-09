package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByLogin(String login);
}
