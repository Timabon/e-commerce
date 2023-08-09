package com.example.SpringDemo.e_commerce.product;

import com.example.SpringDemo.e_commerce.user.UserController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") int id,@RequestBody Product details ){
        return productService.updateProduct(id, details);
    }
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
