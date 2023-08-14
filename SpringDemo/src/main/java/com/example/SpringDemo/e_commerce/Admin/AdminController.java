package com.example.SpringDemo.e_commerce.Admin;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AdminController {

    AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/admin/create")
    public Customer addUser(@RequestBody Customer customer){
       return adminService.addUser(customer);
    }
    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Customer> deleteUser(@PathVariable Long id){
        adminService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

