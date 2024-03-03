package org.example.probarpostman.controller;

import org.example.probarpostman.model.Sala;
import org.example.probarpostman.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {
    @Autowired
    private SalaService salaService;
    //Metodo para crear una sala en la base de datos con un metodo POST en la ruta /api/salas
    // y un objeto Sala en el cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Sala> createSala(@RequestBody Sala sala) {
        Sala newSala = salaService.saveSala(sala);
        return ResponseEntity.ok(newSala);
    }
    //Metodo para obtener todas las salas de la base de datos con un metodo GET en la ruta /api/salas
    @GetMapping
    public ResponseEntity<List<Sala>> getAllSalas() {
        List<Sala> salas = salaService.findAllSalas();
        return ResponseEntity.ok(salas);
    }
    //Metodo para obtener una sala por su id con un metodo GET en la ruta /api/salas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Long id) {
        Sala sala = salaService.findSalaById(id);
        return ResponseEntity.ok(sala);
    }
    //Metodo para actualizar una sala por su id con un metodo PUT en la ruta /api/salas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Long id, @RequestBody Sala updatedSala) {
        Sala sala = salaService.updateSala(id, updatedSala);
        return ResponseEntity.ok(sala);
    }
    //Metodo para eliminar una sala por su id con un metodo DELETE en la ruta /api/salas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id) {
        salaService.deleteSalaById(id);
        return ResponseEntity.ok().build();
    }
}
