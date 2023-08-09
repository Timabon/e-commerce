package com.example.SpringDemo.e_commerce.user;

import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class UserService {
    //TODO CRUD
    //TODO register and login metods

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void register(){};

    public void login(){};

   public User createUser(User user){
        return userRepository.save(user);
   }

    public User getUser(String username){
        if (userRepository.findUserByUsername(username) == null){
            throw new ResourceNotFoundException("User not found: " + username);
        }
        return userRepository.findUserByUsername(username);
    }

    public User updateUser(String userName, User userDetails){
        User user = userRepository.findUserByUsername(userName);
        if(user == null){
            throw new NotFoundException("User not found");
        }

        user.setUsername(userDetails.getUsername());
        user.setE_mail(userDetails.getE_mail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(String username){
        if (userRepository.findUserByUsername(username) == null){
            throw new ResourceNotFoundException("User not found: " + username);
        }
        User user = userRepository.findUserByUsername(username);
        userRepository.delete(user);
    }


    public List<User> findAll() {
       return userRepository.findAll();
    }

    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }
}
