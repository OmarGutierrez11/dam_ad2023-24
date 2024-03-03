package org.example.probarpostman.service;

import org.example.probarpostman.model.Pelicula;
import org.example.probarpostman.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;
    // Otros métodos del servicio
    // Método para guardar una película
    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
    // Método para buscar todas las películas
    public List<Pelicula> findAllPeliculas() {
        return peliculaRepository.findAll();
    }
    // Método para buscar una película por ID
    public Pelicula findPeliculaById(Long id) {
        return peliculaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Pelicula no encontrada con ID: " + id));
    }
    // Método para actualizar una película por ID
    public Pelicula updatePelicula(Long id, Pelicula updatedPelicula) {
        Pelicula existingPelicula = findPeliculaById(id);
        existingPelicula.setNombre(updatedPelicula.getNombre());
        existingPelicula.setDuracion(updatedPelicula.getDuracion());
        return peliculaRepository.save(existingPelicula);
    }
    // Método para eliminar una película por ID
    public void deletePeliculaById(Long id) {
        Pelicula pelicula = findPeliculaById(id);
        peliculaRepository.delete(pelicula);
    }




}
