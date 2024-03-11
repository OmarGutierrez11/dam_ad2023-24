package org.example.cine.controller;

import org.example.cine.model.Sesion;
import org.example.cine.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {
    @Autowired
    private SesionService sesionService;
    @PostMapping
    public ResponseEntity<Sesion> createSesion(@RequestBody Sesion sesion) {
        Sesion newSesion = sesionService.saveSesion(sesion);
        return ResponseEntity.ok(newSesion);
    }

    @GetMapping
    public ResponseEntity<Iterable<Sesion>> getAllSesiones() {
        Iterable<Sesion> sesiones = sesionService.findAllSesiones();
        return ResponseEntity.ok(sesiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion> getSesionById(@PathVariable Long id) {
        Sesion sesion = sesionService.findSesionById(id);
        return ResponseEntity.ok(sesion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sesion> updateSesion(@PathVariable Long id, @RequestBody Sesion updatedSesion) {
        Sesion sesion = sesionService.updateSesion(id, updatedSesion);
        return ResponseEntity.ok(sesion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSesion(@PathVariable Long id) {
        sesionService.deleteSesionById(id);
        return ResponseEntity.ok().build();
    }

}
