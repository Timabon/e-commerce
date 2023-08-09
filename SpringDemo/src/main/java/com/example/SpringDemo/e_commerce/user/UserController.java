package com.example.SpringDemo.e_commerce.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{username}")
    @ResponseBody
    public User getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }

    @PostMapping("/users")
    @ResponseBody
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/users/create")
    @ResponseBody
    public List<User> createUsers(@RequestBody List<User> users){
       return userService.saveAll(users);
    }

    @PutMapping("/users/{username}")
    @ResponseBody
    public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User userDetails){
        User updatedUser = userService.updateUser(username, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/users/{username}")
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
