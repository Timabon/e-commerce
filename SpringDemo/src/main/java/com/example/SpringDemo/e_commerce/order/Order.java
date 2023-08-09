package com.example.SpringDemo.e_commerce.order;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.user.User;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

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
    @JoinColumn(name = "user_id")
    private User user;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date orderDate;
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "description")
    private String orderDescription;

    public Order(){}

    public Order(Long orderId, Long customerId, String orderDescription){
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = Date.valueOf(LocalDate.EPOCH);
        this.orderDescription = orderDescription;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
