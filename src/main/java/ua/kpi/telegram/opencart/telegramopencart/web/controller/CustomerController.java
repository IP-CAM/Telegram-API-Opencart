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

    @PostMapping("/customer/{customerId}/cart/goods/{goodsId}")
    public void addToCart(@PathVariable("customerId") long customerId,
                          @RequestParam("goodsId") long goodsId,
                          @RequestParam("amount") long amount) {
        customerService.addToCart(customerId, goodsId, amount);
    }

    @DeleteMapping("/customer/{name}/cart/goods/{goodsname}")
    public void removeFromCart(@PathVariable("name") long customerId,
                               @RequestParam("goodsname") long goodsId,
                               @RequestParam("amount") long amount) {
        if (amount == 0) {
            customerService.removeGoodsFromCart(customerId, goodsId);

        } else {
            customerService.removeFromCart(customerId, goodsId, amount);
        }
    }

    @GetMapping("/customer/{customerId}/cart/goods")
    public List<Goods> getAllCustomerGoods(@PathVariable("name") long customerId) {
        return customerService.getAllCustomerGoods(customerId);
    }

    @GetMapping("/customer/{customerId}/cart/")
    public Cart getCustomerCart(@PathVariable("customerId") long customerId) {
        return customerService.getCart(customerId);
    }

    @DeleteMapping("/customer/{customerId}/cart/goods")
    public void clearCart(@PathVariable("customerId") long customerId) {
        customerService.clearCart(customerId);
    }
}
