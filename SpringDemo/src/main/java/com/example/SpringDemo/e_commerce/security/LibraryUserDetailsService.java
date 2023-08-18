package com.example.SpringDemo.e_commerce.security;
import java.util.stream.Stream;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.customer.CustomerRepository;
import com.example.SpringDemo.e_commerce.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class LibraryUserDetailsService implements UserDetailsService {

    CustomerRepository customerRepository;
    //TODO error can be here
    LibraryUserDetailsService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findUserByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new LibraryUserdDetails(customer);
    }



}
