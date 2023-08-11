package com.example.SpringDemo.e_commerce.order;

import com.example.SpringDemo.e_commerce.customer.Customer;
import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.e_commerce.user.User;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private String shippingAddress;
    private String invoiceAddress;
    //@ManyToMany(cascade = CascadeType.ALL)
    //List<Product> products;
    @ElementCollection
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "product_amount")
    @CollectionTable(name = "products_table", joinColumns = @JoinColumn(name = "order_id"))
    Map<Product, Integer> productMap = new HashMap<>();


    //todo total price

    public Order(){}

    public Order(Long customerId, String orderDescription){
        this.orderDate = Date.valueOf(LocalDate.EPOCH);
        this.orderDescription = orderDescription;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
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


    public void addProduct(Product product) {
        this.productMap.merge(product, 1, Integer::sum);

/*        if(this.productMap.containsKey(product)){
            this.productMap.put(product, this.productMap.get(product) +1);
        } else {
            this.productMap.put(product, 1);
        }*/

    }
}
