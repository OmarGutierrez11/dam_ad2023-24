package org.example.probarpostman.controller;

import org.example.probarpostman.model.Socio;
import org.example.probarpostman.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socios")
public class SocioController {
    @Autowired
    private SocioService socioService;
    //Metodo para crear un socio en la base de datos con un metodo POST en la ruta /api/socios
    // y un objeto socio en el cuerpo de la peticion
    @PostMapping
    public ResponseEntity<Socio> createSocio(@RequestBody Socio socio) {
        Socio newSocio = socioService.saveSocio(socio);
        return ResponseEntity.ok(newSocio);
    }
    //Metodo para obtener todos los socios de la base de datos con un metodo GET en la ruta /api/socios
    @GetMapping
    public ResponseEntity<Iterable<Socio>> getAllSocios() {
        Iterable<Socio> socios = socioService.findAllSocios();
        return ResponseEntity.ok(socios);
    }
    //Metodo para obtener un socio por su id con un metodo GET en la ruta /api/socios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Socio> getSocioById(@PathVariable Long id) {
        Socio socio = socioService.findSocioById(id);
        return ResponseEntity.ok(socio);
    }
    //Metodo para actualizar un socio por su id con un metodo PUT en la ruta /api/socios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Socio> updateSocio(@PathVariable Long id, @RequestBody Socio updatedSocio) {
        Socio socio = socioService.updateSocio(id, updatedSocio);
        return ResponseEntity.ok(socio);
    }
    //Metodo para eliminar un socio por su id con un metodo DELETE en la ruta /api/socios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocio(@PathVariable Long id) {
        socioService.deleteSocioById(id);
        return ResponseEntity.ok().build();
    }
}
