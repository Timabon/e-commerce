package com.example.SpringDemo.e_commerce.customer;

import com.example.SpringDemo.e_commerce.user.User;
import jakarta.persistence.Entity;

@Entity
public class Customer extends User {
  /*  private List<Order> orders;*/

    private String shippingAddress;
    private String invoiceAddress;


    public Customer(){};
    public Customer(String username, String e_mail, String password, String role){
        super(username, e_mail, password, role);
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
