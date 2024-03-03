package org.example.probarpostman.service;

import org.example.probarpostman.model.Cine;
import org.example.probarpostman.repository.CineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CineService {
    @Autowired
    private CineRepository cineRepository;
    // Otros métodos del servicio
    //Método para guardar un cine en la base de datos
    public Cine saveCine(Cine cine) {

        return cineRepository.save(cine);
    }
    //Método para obtener un cine por su id de la base de datos
    public Optional<Cine> getCineById(Long id) {

        return cineRepository.findById(id);
    }
    //Método para obtener todos los cines de la base de datos (sin filtros)
    public List<Cine> getAllCines() {

        return cineRepository.findAll();
    }
    //Método para actualizar un cine de la base de datos
    public Cine updateCine(Cine cine) {

        return cineRepository.save(cine);
    }
    //Método para eliminar un cine de la base de datos por su id
    public void deleteCineById(Long id) {

        cineRepository.deleteById(id);
    }

}
