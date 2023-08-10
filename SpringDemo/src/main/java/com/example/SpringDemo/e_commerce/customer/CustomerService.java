package com.example.SpringDemo.e_commerce.customer;

import com.example.SpringDemo.e_commerce.basket.Basket;
import com.example.SpringDemo.e_commerce.order.Order;
import com.example.SpringDemo.e_commerce.order.OrderRepository;
import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.e_commerce.product.ProductRepository;
import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.customer.CustomerRepository;
import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    OrderRepository orderRepository;

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
