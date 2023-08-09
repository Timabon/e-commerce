package com.example.SpringDemo.e_commerce.user;

import com.example.SpringDemo.e_commerce.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

  /*  List<User> findByUsername(String username);
    @Query(value = "Select * from users where username", nativeQuery = true)
    List<User> findAllUsersWithCustomQuery(String username);
*/


}