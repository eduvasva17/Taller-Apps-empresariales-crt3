package com.eamapp.store.controller;

import com.eamapp.store.model.entity.Maker;
import com.eamapp.store.model.response.MakerResponseRest;
import com.eamapp.store.model.service.IMakerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("api")
public class MakerRestController {

    private IMakerService makerService;
    public MakerRestController(IMakerService makerService){
        this.makerService = makerService;
    }

    //Get all categories
    @GetMapping("/makers")
    public ResponseEntity<MakerResponseRest> searchMakers(){
        return makerService.search();
    }

    //Get all categories by id
    //@param id
    @GetMapping("/makers/{id}")
    public ResponseEntity<MakerResponseRest> searchById(@PathVariable Long id){
        return makerService.searchById(id);
    }

    //save category
    @PostMapping("/makers")
    public ResponseEntity<MakerResponseRest> save(@RequestBody Maker maker){
        return makerService.save(maker);
    }

    //update category
    @PutMapping("/makers/{id}")
    public ResponseEntity<MakerResponseRest> update(@RequestBody Maker maker, @PathVariable Long id){
        return makerService.update(maker, id);
    }

    //delete category
    @DeleteMapping("/makers/{id}")
    public ResponseEntity<MakerResponseRest> delete(@PathVariable Long id){
        return makerService.deleteById(id);
    }

}
