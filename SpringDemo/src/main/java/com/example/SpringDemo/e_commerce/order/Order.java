package com.example.SpringDemo.e_commerce.order;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.user.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date orderDate;

    @Column(name = "description")
    private String orderDescription;

    public Order(){}

    public Order(Long customerId, String orderDescription){
        this.orderDate = Date.valueOf(LocalDate.EPOCH);
        this.orderDescription = orderDescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
