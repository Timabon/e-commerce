package com.example.SpringDemo.e_commerce.basket;

import com.example.SpringDemo.e_commerce.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BasketController {
    //TODO differenciate the baskets between the users
    Basket basket;

    @Autowired
    public BasketController (Basket basket){
        this.basket = basket;
    }

    @GetMapping("/users/{username}/basket")
    public Map<Product, Integer> getBasket(@PathVariable("username") String username){
        System.out.println(RequestContextHolder.getRequestAttributes().getSessionId());
        return basket.getProductMap();
    }
    @PostMapping("/users/{username}/basket")
    public void addProductsToBasket(@PathVariable("username") String username,@RequestBody Product product,@RequestParam int amount){
        System.out.println(RequestContextHolder.getRequestAttributes().getSessionId());
        basket.addProduct(product,amount);
    }

    @DeleteMapping("/users/{username}/basket/delete")
    public void clearBasket(@PathVariable("username") String username){
        basket.clearBasket();
    }
}
