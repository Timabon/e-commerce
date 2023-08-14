package com.example.SpringDemo.e_commerce.Admin;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.customer.CustomerRepository;
import com.example.SpringDemo.e_commerce.customer.CustomerService;
import com.example.SpringDemo.e_commerce.user.User;
import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends User{
    CustomerRepository customerRepository;

    public AdminService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public Customer addUser(Customer customer){
        return customerRepository.save(customer);
    }


    public void deleteUser(Long id){
        if (customerRepository.findByUserId(id) == null){
            throw new ResourceNotFoundException("User not foud");
        }
        customerRepository.deleteById(id);
    }
}
