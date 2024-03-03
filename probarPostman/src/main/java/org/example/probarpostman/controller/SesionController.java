package org.example.probarpostman.controller;

import org.example.probarpostman.model.Sesion;
import org.example.probarpostman.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {
    @Autowired
    private SesionService sesionService;
    //Metodo para crear una sesion en la base de datos con un metodo POST y un body en formato JSON
    // con los datos de la sesion a crear
    @PostMapping
    public ResponseEntity<Sesion> createSesion(@RequestBody Sesion sesion) {
        Sesion newSesion = sesionService.saveSesion(sesion);
        return ResponseEntity.ok(newSesion);
    }
    //Metodo para obtener todas las sesiones de la base de datos con un metodo GET
    @GetMapping
    public ResponseEntity<Iterable<Sesion>> getAllSesiones() {
        Iterable<Sesion> sesiones = sesionService.findAllSesiones();
        return ResponseEntity.ok(sesiones);
    }
    //Metodo para obtener una sesion por su id con un metodo GET y un parametro en la url
    @GetMapping("/{id}")
    public ResponseEntity<Sesion> getSesionById(@PathVariable Long id) {
        Sesion sesion = sesionService.findSesionById(id);
        return ResponseEntity.ok(sesion);
    }
    //Metodo para actualizar una sesion por su id con un metodo PUT y un parametro en la url y un body en formato JSON
    @PutMapping("/{id}")
    public ResponseEntity<Sesion> updateSesion(@PathVariable Long id, @RequestBody Sesion updatedSesion) {
        Sesion sesion = sesionService.updateSesion(id, updatedSesion);
        return ResponseEntity.ok(sesion);
    }
    //Metodo para eliminar una sesion por su id con un metodo DELETE y un parametro en la url
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSesion(@PathVariable Long id) {
        sesionService.deleteSesionById(id);
        return ResponseEntity.ok().build();
    }

}
