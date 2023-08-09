package com.example.SpringDemo.e_commerce.customer;

import com.example.SpringDemo.e_commerce.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findUserByUsername(String username);
}
