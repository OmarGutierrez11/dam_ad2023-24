package com.example.omar.controller;

import com.example.omar.model.Barco;
import com.example.omar.service.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/barcos")
public class BarcoController {
    @Autowired
    private BarcoService barcoService;
    // Crear un nuevo barco
    @PostMapping
    public ResponseEntity<Barco> createBarco(@RequestBody Barco
                                                     barco) {
        Barco newBarco = barcoService.saveBarco(barco);
        return ResponseEntity.ok(newBarco);
    }
    // Obtener todos los barcos
    @GetMapping
    public ResponseEntity<List<Barco>> getAllBarcos() {
        List<Barco> barcos = barcoService.findAllBarcos();
        return ResponseEntity.ok(barcos);
    }
    // Obtener un barco por ID
    @GetMapping("/{id}")
    public ResponseEntity<Barco> getBarcoById(@PathVariable
                                              Long id) {
        Barco barco = barcoService.findBarcoById(id);
        return ResponseEntity.ok(barco);
    }
    // Actualizar un barco por ID
    @PutMapping("/{id}")
    public ResponseEntity<Barco> updateBarco(@PathVariable Long
                                                     id, @RequestBody Barco updatedBarco) {
        Barco barco = barcoService.updateBarco(id,
                updatedBarco);
        return ResponseEntity.ok(barco);
    }
    // Eliminar un barco por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarco(@PathVariable Long id) {
        barcoService.deleteBarco(id);
        return ResponseEntity.ok().build();
    }


}
