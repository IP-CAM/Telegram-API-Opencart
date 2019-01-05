package ua.kpi.telegram.opencart.telegramopencart.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Cart;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.service.CustomerService;
import ua.kpi.telegram.opencart.telegramopencart.web.dto.CustomerDto;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PutMapping("/customer")
    public void registerCustomer(@RequestBody CustomerDto customerDto) {
        customerService.register(customerDto);
    }

    @PostMapping("/customer/{name}/cart/goods/{goodsname}")
    public void addToCart(@PathVariable("name") String customerName,
                          @RequestParam("goodsname") String goodsName,
                          @RequestParam("amount") long amount) {
        customerService.addToCart(customerName, goodsName, amount);
    }

    @DeleteMapping("/customer/{name}/cart/goods/{goodsname}")
    public void removeFromCart(@PathVariable("name") String customerName,
                               @RequestParam("goodsname") String goodsName,
                               @RequestParam("amount") long amount) {
        if (amount == 0) {
            customerService.removeGoodsFromCart(customerName, goodsName);

        } else {
            customerService.removeFromCart(customerName, goodsName, amount);
        }
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
    public void clearCart(@PathVariable("name") String login) {
        customerService.clearCart(login);
    }
}
