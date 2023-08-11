package com.example.SpringDemo.e_commerce.customer;

import com.example.SpringDemo.e_commerce.basket.Basket;
import com.example.SpringDemo.e_commerce.order.Order;
import com.example.SpringDemo.e_commerce.order.OrderDTO;
import com.example.SpringDemo.e_commerce.order.OrderRepository;
import com.example.SpringDemo.e_commerce.order.OrderService;
import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.e_commerce.product.ProductRepository;
import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.customer.CustomerRepository;
import com.example.SpringDemo.e_commerce.user.User;
import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    OrderRepository orderRepository;

    OrderService orderService;

    Basket basket;
    //TODO CRUD
    //TODO register and login metods

    public void register(){};

    public void login(){};

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomer(String customername){
        if (customerRepository.findUserByUsername(customername) == null){
            throw new ResourceNotFoundException("Customer not found: " + customername);
        }
        return customerRepository.findUserByUsername(customername);
    }

    public Customer updateCustomer(String customerName, Customer customerDetails){
        Customer customer = customerRepository.findUserByUsername(customerName);
        if(customer == null){
            throw new NotFoundException("Customer not found");
        }

        customer.setUsername(customerDetails.getUsername());
        customer.setE_mail(customerDetails.getE_mail());
        customer.setPassword(customerDetails.getPassword());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String customername){
        if (customerRepository.findUserByUsername(customername) == null){
            throw new ResourceNotFoundException("Customer not found: " + customername);
        }
        Customer customer = customerRepository.findUserByUsername(customername);
        customerRepository.delete(customer);
    }


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    public CustomerService(CustomerRepository customerRepository, OrderRepository orderRepository, Basket basket, OrderService orderService){
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.basket = basket;
    }
    public void addToBasket(Product product, int amount){
        basket.addProduct(product, amount);
    }

    public void viewOrders(){

    }

    public void checkout(String username, String desc){


        //todo create order object;
        Order order = new Order();
        //todo fill order object with products from basket
        order.addProducts(basket.getProductMap());
        //todo fill order object with customer in
    order.setCustomer(getCustomer(username));
    //todo add descrtipon
        order.setOrderDescription(desc);
        //todo save orderobject using orderrepo
        orderRepository.save(order);
        //todo clear basket
        basket.clearBasket();
    }

    public void invoiceAddress(){}

    public void shippingAddress(){}
}
