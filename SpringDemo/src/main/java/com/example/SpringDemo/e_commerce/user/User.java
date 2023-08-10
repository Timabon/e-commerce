package com.example.SpringDemo.e_commerce.user;

import jakarta.persistence.*;

/*@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)*/
@MappedSuperclass
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "username")
    private String username;
    @Column(name = "e_mail")
    private String e_mail;
    @Column(name = "password")
    private String password;



    public User(){}


    public User(String username, String e_mail, String password){
        super();
        this.username = username;
        this.e_mail = e_mail;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
