package com.eamapp.store.model.service;

import com.eamapp.store.model.entity.Category;
import com.eamapp.store.model.repository.ICategoryDao;
import com.eamapp.store.model.response.CategoryResponseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService{
    private ICategoryDao categoryDao;

    public CategoryServiceImpl(ICategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> search() {
        CategoryResponseRest response =new CategoryResponseRest();
        try {
            List<Category> categorys = categoryDao.findAll();
            response.getCategoryResponse().setCategorys(categorys);
            response.setMetadata("Ok","00", "Respuesta Exitosa");
        }catch (Exception e){
            response.setMetadata("Failed", "-1", "Error al consultar");
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryResponseRest> searchById(Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> categorys =new ArrayList<>();
        try{
            Optional<Category> category = categoryDao.findById(id);
            if (category.isPresent()){
                categorys.add(category.get());
                response.getCategoryResponse().setCategorys(categorys);
                response.setMetadata("Ok","00","Respuesta Exitosa");
            }else {
                response.setMetadata("Failed","-1","Respuesta Fallida");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            }catch (Exception e){
            response.setMetadata("Failed","-1", "Error al consultar por ID");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param Category
     * @return CategoryResponseRest
     */
    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> save(Category category) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> categorys = new ArrayList<>();
        try{
            Category categorySaved = categoryDao.save(category);
            categorys.add(categorySaved);
            response.getCategoryResponse().setCategorys(categorys);
            response.setMetadata("OK","00","Respuesta Exitosa");
        }catch (Exception e){
            response.setMetadata("Failed","-1","Error al grabar fabricante");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param category
     * @param id
     * @return ResponseEntity
     */
    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> update(Category category, Long id) {
        CategoryResponseRest response = new CategoryResponseRest();
        List<Category> categorys = new ArrayList<>();
        try{
            Optional<Category> categorySearch = categoryDao.findById(id);
            if (categorySearch.isPresent()){
                //Se actualizara la categoria
                categorySearch.get().setName(category.getName());
                categorySearch.get().setDescription(category.getDescription());
                Category categoryToUpdate = categoryDao.save(categorySearch.get());
                categorys.add(categoryToUpdate);
                response.getCategoryResponse().setCategorys(categorys);
                response.setMetadata("Ok","00","Categoria actualizado");
            }else{
                response.setMetadata("Failed","-1","Error al actualizar Categoria");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response.setMetadata("Failed","-1","Error al actualizar Categoria");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param id
     * @return ResponseEntity
     */
    @Override
    @Transactional
    public ResponseEntity<CategoryResponseRest> deleteById(Long id) {
       CategoryResponseRest response = new CategoryResponseRest();
        try {
            categoryDao.deleteById(id);
            response.setMetadata("OK","00","Categoria eliminado");
        }catch (Exception e){
            response.setMetadata("Failde","-1","Error al eliminar");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
