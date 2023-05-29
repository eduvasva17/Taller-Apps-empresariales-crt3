package com.eamapp.store.model.repository;

import com.eamapp.store.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDao extends JpaRepository<Category, Long> {
}