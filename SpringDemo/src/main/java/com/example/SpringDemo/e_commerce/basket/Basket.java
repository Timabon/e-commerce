package com.example.SpringDemo.e_commerce.basket;

import com.example.SpringDemo.e_commerce.product.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
// todo total price


    private Map<Product, Integer> productMap;

    public Basket(){
        this.productMap = new HashMap<>();
    }
    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product, int amount){
        this.productMap.put(product, amount);
    }

    public void clearBasket(){
        productMap.clear();
    }
}
