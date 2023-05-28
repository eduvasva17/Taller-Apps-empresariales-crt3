package com.eamapp.store.model.service;

import com.eamapp.store.model.entity.Category;
import com.eamapp.store.model.response.CategoryResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    public ResponseEntity<CategoryResponseRest> search();
    public ResponseEntity<CategoryResponseRest> searchById(Long id);
    public ResponseEntity<CategoryResponseRest> save(Category category);
    public ResponseEntity<CategoryResponseRest> update(Category category, Long id);
    public ResponseEntity<CategoryResponseRest> deleteById(Long id);
}
