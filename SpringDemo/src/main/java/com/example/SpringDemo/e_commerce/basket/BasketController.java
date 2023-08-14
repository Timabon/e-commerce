package com.example.SpringDemo.e_commerce.basket;

import com.example.SpringDemo.e_commerce.product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class BasketController {
    //TODO differenciate the baskets between the users
    Basket basket;

    public BasketController (Basket basket){
        this.basket = basket;
    }

    @GetMapping("/users/{username}/basket")
    public Map<Product, Integer> getBasket(@PathVariable("username") String username){
        return basket.getProductMap();
    }
    @PostMapping("/users/{username}/basket")
    public void addProductsToBasket(@PathVariable("username") String username,@RequestBody Product product,@RequestParam int amount){
        basket.addProduct(product,amount);
    }

    @DeleteMapping("/users/{username}/basket/delete")
    public void clearBasket(@PathVariable("username") String username){
        basket.clearBasket();
    }
}
