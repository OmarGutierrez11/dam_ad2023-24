package org.example.probarpostman.controller;

import org.example.probarpostman.model.Pelicula;
import org.example.probarpostman.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    //Metodo para crear una pelicula
    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula newPelicula = peliculaService.savePelicula(pelicula);
        return ResponseEntity.ok(newPelicula);
    }
    //Metodo para obtener todas las peliculas
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.findAllPeliculas();
        return ResponseEntity.ok(peliculas);
    }
    //Metodo para obtener una pelicula por su id
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(Long id) {
        Pelicula pelicula = peliculaService.findPeliculaById(id);
        return ResponseEntity.ok(pelicula);
    }
    //Metodo para actualizar una pelicula por su id
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable Long id, @RequestBody Pelicula updatedPelicula) {
        Pelicula pelicula = peliculaService.updatePelicula(id, updatedPelicula);
        return ResponseEntity.ok(pelicula);
    }
    //Metodo para eliminar una pelicula por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable Long id) {
        peliculaService.deletePeliculaById(id);
        return ResponseEntity.ok().build();
    }
}
