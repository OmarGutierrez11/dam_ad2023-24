package org.example.cine.controller;

import org.example.cine.model.Empleado;
import org.example.cine.model.Pelicula;
import org.example.cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;
    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula newPelicula = peliculaService.savePelicula(pelicula);
        return ResponseEntity.ok(newPelicula);
    }
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.findAllPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(Long id) {
        Pelicula pelicula = peliculaService.findPeliculaById(id);
        return ResponseEntity.ok(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable Long id, @RequestBody Pelicula updatedPelicula) {
        Pelicula pelicula = peliculaService.updatePelicula(id, updatedPelicula);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable Long id) {
        peliculaService.deletePeliculaById(id);
        return ResponseEntity.ok().build();
    }
}
