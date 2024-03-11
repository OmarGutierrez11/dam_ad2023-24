package org.example.cine.controller;

import org.example.cine.model.Sala;
import org.example.cine.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {
    @Autowired
    private SalaService salaService;
    @PostMapping
    public ResponseEntity<Sala> createSala(@RequestBody Sala sala) {
        Sala newSala = salaService.saveSala(sala);
        return ResponseEntity.ok(newSala);
    }

    @GetMapping
    public ResponseEntity<List<Sala>> getAllSalas() {
        List<Sala> salas = salaService.findAllSalas();
        return ResponseEntity.ok(salas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Long id) {
        Sala sala = salaService.findSalaById(id);
        return ResponseEntity.ok(sala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Long id, @RequestBody Sala updatedSala) {
        Sala sala = salaService.updateSala(id, updatedSala);
        return ResponseEntity.ok(sala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        salaService.deleteSalaById(id);
        return ResponseEntity.ok().build();
    }
}
