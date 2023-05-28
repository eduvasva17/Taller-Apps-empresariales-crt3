package com.eamapp.store.model.service;

import com.eamapp.store.model.entity.Maker;
import com.eamapp.store.model.repository.IMakerDao;
import com.eamapp.store.model.response.MakerResponseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService{
    private IMakerDao makerDao;

    public MakerServiceImpl(IMakerDao makerDao){
        this.makerDao = makerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<MakerResponseRest> search() {
        MakerResponseRest response =new MakerResponseRest();
        try {
            List<Maker> makers = makerDao.findAll();
            response.getMakerResponse().setMakers(makers);
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
    public ResponseEntity<MakerResponseRest> searchById(Long id) {
        MakerResponseRest response = new MakerResponseRest();
        List<Maker> makers =new ArrayList<>();
        try{
            Optional<Maker> maker = makerDao.findById(id);
            if (maker.isPresent()){
                makers.add(maker.get());
                response.getMakerResponse().setMakers(makers);
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
     * @param maker
     * @return MakerResponseRest
     */
    @Override
    @Transactional
    public ResponseEntity<MakerResponseRest> save(Maker maker) {
        MakerResponseRest response = new MakerResponseRest();
        List<Maker> makers = new ArrayList<>();
        try{
            Maker makerSaved = makerDao.save(maker);
            makers.add(makerSaved);
            response.getMakerResponse().setMakers(makers);
            response.setMetadata("OK","00","Respuesta Exitosa");
        }catch (Exception e){
            response.setMetadata("Failed","-1","Error al grabar fabricante");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param maker
     * @param id
     * @return ResponseEntity
     */
    @Override
    @Transactional
    public ResponseEntity<MakerResponseRest> update(Maker maker, Long id) {
        MakerResponseRest response = new MakerResponseRest();
        List<Maker> makers = new ArrayList<>();
        try{
            Optional<Maker> makerSearch = makerDao.findById(id);
            if (makerSearch.isPresent()){
                //Se actualizara el fabricante
                makerSearch.get().setName(maker.getName());
                Maker makerToUpdate = makerDao.save(makerSearch.get());
                makers.add(makerToUpdate);
                response.getMakerResponse().setMakers(makers);
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
    public ResponseEntity<MakerResponseRest> deleteById(Long id) {
        MakerResponseRest response = new MakerResponseRest();
        try {
            makerDao.deleteById(id);
            response.setMetadata("OK","00","Fabricante eliminado");
        }catch (Exception e){
            response.setMetadata("Failde","-1","Error al eliminar");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
