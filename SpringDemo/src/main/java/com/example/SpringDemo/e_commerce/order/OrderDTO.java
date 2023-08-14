package com.example.SpringDemo.e_commerce.order;

public class OrderDTO {
    private String orderDescription;
    private Long customerId;

    public OrderDTO(){

    }

    public OrderDTO(String orderDescription, Long customerId){
        this.orderDescription = orderDescription;
        this.customerId = customerId;
    }
    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
