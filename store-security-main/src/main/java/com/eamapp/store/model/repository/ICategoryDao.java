package com.eamapp.store.model.repository;

import com.eamapp.store.model.entity.Categoty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDao extends JpaRepository<Categoty, Long> {
}
