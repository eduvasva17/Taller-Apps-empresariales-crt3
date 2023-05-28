package com.eamapp.store.model.repository;

import com.eamapp.store.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product, Long> {
}
