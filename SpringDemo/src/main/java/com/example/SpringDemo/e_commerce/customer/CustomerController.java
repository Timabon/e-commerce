package com.example.SpringDemo.e_commerce.customer;
import com.example.SpringDemo.e_commerce.order.Order;
import com.example.SpringDemo.e_commerce.order.OrderDTO;
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

    @PostMapping("/users/orders")
    @ResponseBody
    public Order createOrder(@RequestBody OrderDTO orderDto){
        return customerService.createOrder(orderDto);
    }
    @GetMapping("/users/orders/{id}")
    public Order getOrder(@PathVariable Long id){
        return customerService.getOrder(id);
    }
    @GetMapping("/users/orders/all-orders/{id}")
    public List<Order> getAllOrdersOfUser(@PathVariable Long id){
        return customerService.getAllOrdersOfUser(id);
    }
    @PutMapping("/users/orders/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order){
        customerService.updateOrder(id,order);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/users/orders/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long id){
        customerService.deleteOrder(id);
        return ResponseEntity.notFound().build();
    }
}
