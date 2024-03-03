package org.example.probarpostman.controller;

import org.example.probarpostman.model.Cine;
import org.example.probarpostman.service.CineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cines")
public class CineController {
    @Autowired
    private CineService cineService;
    //Metodo para crear un cine en la base de datos con el metodo POST en la url /api/cines
    // y el cuerpo de la peticion es un objeto de tipo Cine en formato JSON
    @PostMapping
    public ResponseEntity<Cine> createCine(@RequestBody Cine cine) {
        Cine newCine = cineService.saveCine(cine);
        return ResponseEntity.ok(newCine);
    }
    //Metodo para obtener todos los cines de la base de datos con el metodo GET en la url /api/cines
    @GetMapping
    public ResponseEntity<List<Cine>> getAllCines() {
        List<Cine> cines = cineService.getAllCines();
        return ResponseEntity.ok(cines);
    }
    //Metodo para obtener un cine por su id con el metodo GET en la url /api/cines/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cine> getCineById(@PathVariable Long id) {
        Cine cine = cineService.getCineById(id).orElse(null);
        return ResponseEntity.ok(cine);
    }
    //Metodo para actualizar un cine por su id con el metodo PUT en la url /api/cines/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Cine> updateCine(@PathVariable Long id, @RequestBody Cine updatedCine) {
        updatedCine.setId(id);
        Cine cine = cineService.updateCine(updatedCine);
        return ResponseEntity.ok(cine);
    }
    //Metodo para eliminar un cine por su id con el metodo DELETE en la url /api/cines/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCine(@PathVariable Long id) {
        cineService.deleteCineById(id);
        return ResponseEntity.ok().build();
    }


}
