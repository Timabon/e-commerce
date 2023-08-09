package com.example.SpringDemo.e_commerce.customer;

import com.example.SpringDemo.e_commerce.basket.Basket;
import com.example.SpringDemo.e_commerce.order.Order;
import com.example.SpringDemo.e_commerce.order.OrderRepository;
import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.e_commerce.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    OrderRepository orderRepository;

    Basket basket;


    public CustomerService(CustomerRepository customerRepository, OrderRepository orderRepository, Basket basket){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.basket = basket;
    }
    public void addToBasket(Product product){
        basket.addProduct(product);
    }

    public void viewOrders(){

    }

    public void checkout(){
        //todo create order object
        //todo fill order object with products from basket
        //todo fill order object with customer info
        //todo save orderobject using orderrepo
        //todo clear basket
    }

    public void invoiceAddress(){}

    public void shippingAddress(){}
}
