package com.example.SpringDemo.e_commerce.catalog;

import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.e_commerce.user.User;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogId;

    @Column
    private String name;
    @ManyToMany
    List<Product> products;

    public Catalog(){}

    public Catalog(String name){
        this.name = name;
    }
    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }


    public void removeProduct(int id) {
        Product product = products.get(id);
        this.products.remove(product);
    }
}
