package com.eamapp.store.controller;

import com.eamapp.store.model.entity.Product;
import com.eamapp.store.model.response.ProductResponseRest;
import com.eamapp.store.model.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api")
public class ProductRestController {

    private IProductService productService;
    public ProductRestController(IProductService productService){
        this.productService = productService;
    }

    //Get all Products
    @GetMapping("/products")
    public ResponseEntity<ProductResponseRest> searchProducts(){
        return productService.search();
    }

    //Get all Products by id
    //@param id
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> searchById(@PathVariable Long id){
        return productService.searchById(id);
    }

    //save Product
    @PostMapping("/products")
    public ResponseEntity<ProductResponseRest> save(@RequestBody Product product){
        return productService.save(product);
    }

    //update Product
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> update(@RequestBody Product product, @PathVariable Long id){
        return productService.update(product, id);
    }

    //delete category
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> delete(@PathVariable Long id){
        return productService.deleteById(id);
    }

}
