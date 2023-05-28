package com.eamapp.store.model.service;

import com.eamapp.store.model.entity.Product;
import com.eamapp.store.model.repository.IProductDao;
import com.eamapp.store.model.response.ProductResponseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{
    private IProductDao productDao;

    public ProductServiceImpl(IProductDao productDao){
        this.productDao =productDao;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ProductResponseRest> search() {
       ProductResponseRest response =new ProductResponseRest();
        try {
            List<Product> products = productDao.findAll();
            response.getProductResponse().setProducts(products);
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
    public ResponseEntity<ProductResponseRest> searchById(Long id) {
        ProductResponseRest response = new ProductResponseRest();
        List<Product> products =new ArrayList<>();
        try{
            Optional<Product> product = productDao.findById(id);
            if (product.isPresent()){
                products.add(product.get());
                response.getProductResponse().setProducts(products);
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
     * @param product
     * @return ProductResponseRest
     */
    @Override
    @Transactional
    public ResponseEntity<ProductResponseRest> save(Product product) {
        ProductResponseRest response = new ProductResponseRest();
        List<Product> products = new ArrayList<>();
        try{
            Product productSaved = productDao.save(product);
            products.add(productSaved);
            response.getProductResponse().setProducts(products);
            response.setMetadata("OK","00","Respuesta Exitosa");
        }catch (Exception e){
            response.setMetadata("Failed","-1","Error al grabar producto");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param Product
     * @param id
     * @return ResponseEntity
     */
    @Override
    @Transactional
    public ResponseEntity<ProductResponseRest> update(Product product, Long id) {
        ProductResponseRest response = new ProductResponseRest();
        List<Product> products = new ArrayList<>();
        try{
            Optional<Product> productSearch = productDao.findById(id);
            if (productSearch.isPresent()){
                //Se actualizara el producto
                productSearch.get().setName(product.getName());
                Product productToUpdate = productDao.save(productSearch.get());
                products.add(productToUpdate);
                response.getProductResponse().setProducts(products);
                response.setMetadata("Ok","00","Fabricante actualizado");
            }else{
                response.setMetadata("Failed","-1","Error al actualizar Fabricante");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response.setMetadata("Failed","-1","Error al actualizar Fabricante");
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
    public ResponseEntity<ProductResponseRest> deleteById(Long id) {
       ProductResponseRest response = new ProductResponseRest();
        try {
            productDao.deleteById(id);
            response.setMetadata("OK","00","Producto eliminado");
        }catch (Exception e){
            response.setMetadata("Failde","-1","Error al eliminar");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
