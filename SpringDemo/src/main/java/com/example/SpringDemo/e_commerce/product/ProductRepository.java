package com.example.SpringDemo.e_commerce.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductId(int id);
    Product deleteProductByProductId(int id);
}
