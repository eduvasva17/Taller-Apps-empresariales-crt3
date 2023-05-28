package com.eamapp.store.model.service;

import com.eamapp.store.model.entity.Maker;
import com.eamapp.store.model.response.MakerResponseRest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMakerService {
    public ResponseEntity<MakerResponseRest> search();
    public ResponseEntity<MakerResponseRest> searchById(Long id);
    public ResponseEntity<MakerResponseRest> save(Maker maker);
    public ResponseEntity<MakerResponseRest> update(Maker maker, Long id);
    public ResponseEntity<MakerResponseRest> deleteById(Long id);
}
