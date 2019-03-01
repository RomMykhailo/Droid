package com.example.droid.service;

import com.example.droid.entity.DroidEntity;
import com.example.droid.exceptions.DroidExistsException;
import com.example.droid.exceptions.NotFoundException;
import com.example.droid.repository.DroidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DroidService {
    @Autowired
    private DroidRepository droidRepository;

    public List<DroidEntity> getAllDroids (){
        List<DroidEntity> droids = droidRepository.findAll();
        return droids;
    }

    public DroidEntity createDroid (DroidEntity droidEntity){
        boolean exists = !droidRepository.getAllByManufacturerAndModelId(droidEntity.getManufacturer(),droidEntity.getModelId()).isEmpty();
        if(exists){
            throw new DroidExistsException("Droid "+ droidEntity.getManufacturer()+ " already exists");
        };
        droidRepository.save(droidEntity);
        return droidEntity;

    }

    public DroidEntity getDroidById(Long id){
        boolean exists = droidRepository.existsById(id);
        if(!exists){
            throw new NotFoundException("Droid with id " + id + " not found");
        };
        DroidEntity droidEntity= droidRepository.findById(id).get();
        return droidEntity;
    }

    public DroidEntity updateDroid (Long id, DroidEntity droidEntity){
        boolean exists1 = droidRepository.existsById(id);
        if(!exists1){
            throw new DroidExistsException("Droid with id " + id + " not exists");
        };
        DroidEntity droidEntity1 = droidRepository.findById(id).get();
        boolean exists2 = (droidEntity.getManufacturer().equals(droidEntity1.getManufacturer())&&
                            droidEntity.getModelId().equals(droidEntity1.getModelId()));
        boolean exists3 = !droidRepository.getAllByManufacturerAndModelId(droidEntity.getManufacturer(),droidEntity.getModelId()).isEmpty();
//        if(!exists2 && exists3){
//            throw new DroidExistsException("Droid "+ droidEntity.getManufacturer()+ " already exists");
//        };

        DroidEntity droidEntityFromDB = droidRepository.findById(id).get();
        droidEntityFromDB.setBuiltAt(droidEntity.getBuiltAt());
        droidEntityFromDB.setManufacturer(droidEntity.getManufacturer());
        droidEntityFromDB.setModelId(droidEntity.getModelId());
        droidRepository.save(droidEntityFromDB);
        return droidEntityFromDB;
    }

    public void deleteDroid (Long id){
        boolean exists1 = droidRepository.existsById(id);
        if(!exists1){
            throw new NotFoundException("Droid with id " + id + " not found");
        };
        droidRepository.deleteById(id);
    }
}
