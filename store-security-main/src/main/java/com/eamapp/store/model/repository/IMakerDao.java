package com.eamapp.store.model.repository;

import com.eamapp.store.model.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMakerDao extends JpaRepository<Maker, Long> {
}
