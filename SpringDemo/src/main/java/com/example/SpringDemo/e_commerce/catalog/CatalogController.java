package com.example.SpringDemo.e_commerce.catalog;

import com.example.SpringDemo.e_commerce.product.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class CatalogController {

    CatalogService catalogService;
    @Autowired
    public CatalogController(CatalogService catalogService){
        this.catalogService = catalogService;
    }
    @PostMapping("/catalogs")
    public Catalog createCatalog(@RequestBody String name){
        return catalogService.createCatalog(name);
    }
    @GetMapping("/catalogs")
    public List<Catalog> getCatalogs(){
        return catalogService.getCatalogs();
    }
    @PostMapping("/catalogs/{id}/addproduct")
    public ResponseEntity<Catalog> addProductToCatalog(@PathVariable Long id,@RequestBody Product product){
        return catalogService.addProductToCatalog(id, product);
    }
    @PostMapping("/catalogs/{id}/addproducts")
    public ResponseEntity<Catalog> addProductsToCatalog(@PathVariable Long id,@RequestBody List<Product> products){
        return catalogService.addProductsToCatalog(id, products);
    }
    @DeleteMapping("/catalogs/{catalogId}/{id}")
    //TODO it deletes by position not by id rn
    public ResponseEntity<Catalog> removeProductFromCatalog(@PathVariable Long catalogId,@PathVariable int id){
        return catalogService.removeProductFromCatalog(catalogId,id);
    }

    public List<Product> getAllProducts(Long catalogId){
        return catalogService.getAllProducts(catalogId);
    }

    //todo searchProduct
}
