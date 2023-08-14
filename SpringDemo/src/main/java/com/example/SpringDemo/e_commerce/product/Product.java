package com.example.SpringDemo.e_commerce.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDetails;
    private int productPrice;

    public Product(){

    }

    public Product(String productName, String productDetails, int productPrice){
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && productPrice == product.productPrice && Objects.equals(productName, product.productName) && Objects.equals(productDetails, product.productDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productDetails, productPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
