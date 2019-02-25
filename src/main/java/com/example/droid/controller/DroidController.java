package com.example.droid.controller;

import com.example.droid.entity.DroidEntity;
import com.example.droid.service.DroidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/droid")
@Slf4j
public class DroidController {

    @Autowired
    private DroidService droidService;
    @PostMapping("/add")
    public ResponseEntity addDroid(@RequestBody DroidEntity droid){
        droidService.createDroid(droid);
        return ResponseEntity.ok("Droid added");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDroid(@PathVariable Long id){
        DroidEntity droidEntity = droidService.getDroidById(id);
        return new ResponseEntity(droidEntity, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getDroids(){
        List<DroidEntity> droidEntities = droidService.getAllDroids();
        return new ResponseEntity<>(droidEntities,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDroid(@PathVariable Long id, @RequestBody DroidEntity droid){
        droidService.updateDroid(id, droid);
        return ResponseEntity.ok("Droid updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDroid(@PathVariable Long id){
        droidService.deleteDroid(id);
        return ResponseEntity.ok("Droid deleted");
    }
}
