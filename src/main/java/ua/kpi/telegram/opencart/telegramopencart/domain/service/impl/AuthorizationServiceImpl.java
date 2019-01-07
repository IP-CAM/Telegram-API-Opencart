package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Customer;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.UserRole;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.AuthorizationService;
import ua.kpi.telegram.opencart.telegramopencart.repository.CustomerRepository;

import static java.lang.Long.parseLong;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private final CustomerRepository customerRepository;

    public AuthorizationServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean hasTaxonomyUnitChangeAccess(String authentication) {
        Customer customer = customerRepository.findById(parseLong(authentication));

        return customer.getUserRole() == UserRole.MODERATOR || customer.getUserRole() == UserRole.ADMIN;
    }

    @Override
    public boolean hasRoleChangeChangeAccess(String authentication) {
        Customer customer = customerRepository.findById(parseLong(authentication));

        return customer.getUserRole() == UserRole.ADMIN;
    }
}
