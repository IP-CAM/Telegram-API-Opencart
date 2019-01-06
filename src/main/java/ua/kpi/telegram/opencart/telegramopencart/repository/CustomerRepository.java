package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByUsername(String username);

    Customer findById(long customerId);
}
