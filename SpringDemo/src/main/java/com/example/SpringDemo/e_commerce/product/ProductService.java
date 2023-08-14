package com.example.SpringDemo.e_commerce.product;

import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product getProduct(int id){
        if (productRepository.findByProductId(id) == null){
            throw new ResourceNotFoundException("Product not found");
        }
        return productRepository.findByProductId(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product addProduct(Product product){
       return productRepository.save(product);
    }

    public Product updateProduct(int id, Product details){
        if(productRepository.findByProductId(id) == null){
            throw new ResourceNotFoundException("Product not found");
        }
        Product product = productRepository.findByProductId(id);
        product.setProductDetails(details.getProductDetails());
        product.setProductName(details.getProductName());
        product.setProductPrice(details.getProductPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(int id){
        if (productRepository.findByProductId(id) == null){
            throw new ResourceNotFoundException("Product not found");
        }
        Product product = productRepository.findByProductId(id);
        productRepository.delete(product);
    }


}
