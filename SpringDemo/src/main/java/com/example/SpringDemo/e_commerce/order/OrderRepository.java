package com.example.SpringDemo.e_commerce.order;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(Long id);

    List<Order> findByCustomer_UserId(Long id);
}
