package com.example.SpringDemo.TriangleBeans;

import com.example.SpringDemo.e_commerce.basket.Basket;
import com.example.SpringDemo.e_commerce.customer.CustomerRepository;
import com.example.SpringDemo.e_commerce.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.server.WebSession;

import java.security.Principal;

@Configuration
public class AppConfiguration {
    /*@Bean(name="equilateral")
    public Triangle triangle(){
        return new Triangle("int");
    }

    @Bean(name = "custom")
    public Triangle customTriangle(){
        return new Triangle("Equilateral", 20);
    }

    @Bean(name = "integer")
    public Triangle integer(){
        return new Triangle(20);
    }*/

    @Bean
    @SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public User user(CustomerRepository customerRepository ) {
        return customerRepository.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName() );
    }

    @Bean
    @SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Basket basket(User user){
        return new Basket();
    }
    @Bean
    public Triangle triangle(){
        return new Triangle();
    }
    @Bean(name = "pointA")
    public Point pointA(){
        return new Point(0,0);
    }
    @Bean(name = "pointB")
    public Point pointB(){
        return new Point(-20,0);
    }
    @Bean(name = "pointC")
    public Point pointC(){
        return new Point(0,20);
    }
}
