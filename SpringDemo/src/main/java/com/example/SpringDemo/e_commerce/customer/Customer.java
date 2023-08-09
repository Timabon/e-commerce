package com.example.SpringDemo.e_commerce.customer;

import com.example.SpringDemo.e_commerce.order.Order;
import com.example.SpringDemo.e_commerce.user.User;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends User {
  /*  private List<Order> orders;*/

    private String shippingAddress;
    private String invoiceAddress;


    public Customer(){};
    public Customer(String username, String e_mail, String password){
        super(username, e_mail, password);
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(String invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }
}
