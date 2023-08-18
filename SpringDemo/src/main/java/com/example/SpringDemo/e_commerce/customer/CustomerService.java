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
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    OrderRepository orderRepository;

    OrderService orderService;

    private PasswordEncoder passwordEncoder;
    Basket basket;
    //TODO register and login metods

    public void register(){};

    public void login(){};
    @Transactional
    public Customer createCustomer(Customer customer){
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        System.out.println("Password: " + customer.getPassword());
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

    public CustomerService(CustomerRepository customerRepository, OrderRepository orderRepository, Basket basket, OrderService orderService, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.basket = basket;
    }
    public void addToBasket(Product product, int amount){
        basket.addProduct(product, amount);
    }


    public void checkout(String username, String desc){


        Order order = new Order();

        order.setProductMap(basket.getProductMap());

        Customer customer = getCustomer(username);
        order.setCustomer(customer);
        order.setInvoiceAddress(customer.getInvoiceAddress());
        order.setShippingAddress(customer.getShippingAddress());

        order.setOrderDescription(desc);

        orderRepository.save(order);

        basket.clearBasket();
    }

    public Order createOrder(OrderDTO orderDto) {
        return orderService.createOrder(orderDto);
    }

    public Order getOrder(Long id) {
        return orderService.getOrder(id);
    }

    public List<Order> getAllOrdersOfUser(Long id) {
        return orderService.getAllOrdersOfUser(id);
    }

    public void updateOrder(Long id, Order order) {
        orderService.updateOrder(id,order);
    }

    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }
}
