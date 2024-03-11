package org.example.cine.controller;

import org.example.cine.model.Cine;
import org.example.cine.service.CineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cines")
public class CineController {
    @Autowired
    private CineService cineService;

    @PostMapping
    public ResponseEntity<Cine> createCine(@RequestBody Cine cine) {
        Cine newCine = cineService.saveCine(cine);
        return ResponseEntity.ok(newCine);
    }

    @GetMapping
    public ResponseEntity<List<Cine>> getAllCines() {
        List<Cine> cines = cineService.getAllCines();
        return ResponseEntity.ok(cines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cine> getCineById(@PathVariable Long id) {
        Cine cine = cineService.getCineById(id).orElse(null);
        return ResponseEntity.ok(cine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cine> updateCine(@PathVariable Long id, @RequestBody Cine updatedCine) {
        updatedCine.setId(id);
        Cine cine = cineService.updateCine(updatedCine);
        return ResponseEntity.ok(cine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCine(@PathVariable Long id) {
        cineService.deleteCineById(id);
        return ResponseEntity.ok().build();
    }


}
