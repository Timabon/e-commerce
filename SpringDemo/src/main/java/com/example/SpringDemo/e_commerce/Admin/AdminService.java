package com.example.SpringDemo.e_commerce.Admin;

import com.example.SpringDemo.e_commerce.user.User;
import com.example.SpringDemo.e_commerce.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    UserRepository userRepository;
    public AdminService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void addUser(User user){
        userRepository.save(user);
    }
}
