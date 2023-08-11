package com.example.SpringDemo.e_commerce.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/users")
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/users/{username}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("username") String username){
        return customerService.getCustomer(username);
    }

    @PostMapping("/users")
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer user){
        return customerService.createCustomer(user);
    }

    @PostMapping("/users/create")
    @ResponseBody
    public List<Customer> createCustomers(@RequestBody List<Customer> users){
        return customerService.saveAll(users);
    }

    @PutMapping("/users/{username}")
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@PathVariable("username") String username, @RequestBody Customer userDetails){
        Customer updatedCustomer = customerService.updateCustomer(username, userDetails);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping(value = "/users/{username}")
    @ResponseBody
    public ResponseEntity<Void> deleteCustomer(@PathVariable("username") String username){
        customerService.deleteCustomer(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users/{username}/basket/checkout")

    public void checkout(@PathVariable("username") String username, @RequestBody String description){
        customerService.checkout(username,description);

    }
}
