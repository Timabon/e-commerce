package com.example.SpringDemo.e_commerce.catalog;

import com.example.SpringDemo.e_commerce.product.Product;
import com.example.SpringDemo.e_commerce.product.ProductRepository;
import com.example.SpringDemo.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    CatalogRepository catalogRepository;
    ProductRepository productRepository;

   public CatalogService(CatalogRepository catalogRepository, ProductRepository productRepository){
       this.catalogRepository = catalogRepository;
       this.productRepository = productRepository;
   }

   public Catalog createCatalog(String name){
       Catalog catalog = new Catalog();
       catalog.setName(name);
       return catalogRepository.save(catalog);
   }

    public List<Catalog> getCatalogs(){
       return catalogRepository.findAll();
    }

    public ResponseEntity<Catalog> addProductToCatalog(Long catalogId, Product product){
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(catalogId);
        if(optionalCatalog.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Catalog catalog = optionalCatalog.get();
        catalog.addProduct(product);
        Catalog saved = catalogRepository.save(catalog);
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<Catalog> addProductsToCatalog(Long catalogId, List<Product> products){
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(catalogId);
        if(optionalCatalog.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Catalog catalog = optionalCatalog.get();
        catalog.addProducts(products);
        Catalog saved = catalogRepository.save(catalog);
        return ResponseEntity.ok(saved);
    }

    public ResponseEntity<Catalog> removeProductFromCatalog(Long catalogId,int id){
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(catalogId);
        if(optionalCatalog.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Catalog catalog = optionalCatalog.get();
        catalog.removeProduct(id);
        Catalog saved = catalogRepository.save(catalog);
        return ResponseEntity.ok(saved);
    }

    public List<Product> getAllProducts(Long catalogId){
        Optional<Catalog> optionalCatalog = this.catalogRepository.findById(catalogId);
        if(optionalCatalog.isEmpty()){
            throw new ResourceNotFoundException("Catalog not found");
        }
        Catalog catalog = optionalCatalog.get();
        return catalog.getProducts();
    }

    public void searchProducts(){

    }
}
