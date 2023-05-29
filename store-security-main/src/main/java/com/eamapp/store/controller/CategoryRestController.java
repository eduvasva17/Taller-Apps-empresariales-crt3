package com.eamapp.store.controller;

import com.eamapp.store.model.entity.Category;
import com.eamapp.store.model.response.CategoryResponseRest;
import com.eamapp.store.model.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api")
public class CategoryRestController {

    private ICategoryService categoryService;
    
    public CategoryRestController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

    //Get all categories
    @GetMapping("/categorys")
    public ResponseEntity<CategoryResponseRest> searchCategorys(){
        return categoryService.search();
    }

    //Get all categories by id
    //@param id
    @GetMapping("/categorys/{id}")
    public ResponseEntity<CategoryResponseRest> searchById(@PathVariable Long id){
        return categoryService.searchById(id);
    }

    //save category
    @PostMapping("categorys")
    public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){
        return categoryService.save(category);
    }

    //update category
    @PutMapping("categorys/{id}")
    public ResponseEntity<CategoryResponseRest> update(@RequestBody Category category, @PathVariable Long id){
        return categoryService.update(category, id);
    }

    //delete category
    @DeleteMapping("/categorys/{id}")
    public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id){
        return categoryService.deleteById(id);
    }

}
