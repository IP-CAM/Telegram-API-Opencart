package ua.kpi.telegram.opencart.telegramopencart.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.User;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.UserService;
import ua.kpi.telegram.opencart.telegramopencart.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String login, String phone) {
        User user = new User();

        user.setLogin(login);
        user.setPhone(phone);
        user.setCart(new Cart());

        userRepository.save(user);
    }
}
