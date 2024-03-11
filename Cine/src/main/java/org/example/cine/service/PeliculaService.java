package org.example.cine.service;

import org.example.cine.model.Pelicula;
import org.example.cine.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;
    // Otros métodos del servicio
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> findAllPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula findPeliculaById(Long id) {
        return peliculaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Pelicula no encontrada con ID: " + id));
    }

    public Pelicula updatePelicula(Long id, Pelicula updatedPelicula) {
        Pelicula existingPelicula = findPeliculaById(id);
        existingPelicula.setNombre(updatedPelicula.getNombre());
        existingPelicula.setDuracion(updatedPelicula.getDuracion());
        return peliculaRepository.save(existingPelicula);
    }

    public void deletePeliculaById(Long id) {
        Pelicula pelicula = findPeliculaById(id);
        peliculaRepository.delete(pelicula);
    }




}
