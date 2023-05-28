package com.eamapp.store.model.service;

import com.eamapp.store.model.entity.Product;
import com.eamapp.store.model.response.ProductResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    public ResponseEntity<ProductResponseRest> search();
    public ResponseEntity<ProductResponseRest> searchById(Long id);
    public ResponseEntity<ProductResponseRest> save(Product product);
    public ResponseEntity<ProductResponseRest> update(Product product, Long id);
    public ResponseEntity<ProductResponseRest> deleteById(Long id);
}
