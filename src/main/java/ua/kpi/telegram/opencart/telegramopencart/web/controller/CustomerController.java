package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PutMapping("/customer")
    public void registerCustomer(@RequestParam("login") String login,
                                 @RequestParam("phone") String phone) {
        customerService.register(login, phone);
    }

    @PutMapping("/customer/{name}/cart/goods/{goodsName}")
    public void addToCart(@PathVariable("name") String customerName,
                          @RequestParam("goodsName") String goodsName,
                          @RequestParam("amount") long amount) {
        customerService.addToCart(customerName, goodsName, amount);
    }

    @GetMapping("/customer/{name}/cart/goods")
    public List<Goods> getAllCustomerGoods(@PathVariable("name") String login) {
        return customerService.getAllCustomerGoods(login);
    }

    @GetMapping("/customer/{name}/cart/")
    public Cart getCustomerCart(@PathVariable("name") String login) {
        return customerService.getCart(login);
    }

    @DeleteMapping("/customer/{name}/cart/goods")
    public void clearACart(@PathVariable("name") String login) {
        customerService.clearCart(login);
    }

    @PostMapping("/customer/{name}/cart/goods/{goodsName}")
    public boolean reduceAmountOfGoods(@PathVariable("name") String login,
                                       @PathVariable("goodsName") String goodsName,
                                       @RequestParam("amount") long amount) {
        return customerService.reduceAmountOfGoods(login, goodsName, amount);
    }
}
