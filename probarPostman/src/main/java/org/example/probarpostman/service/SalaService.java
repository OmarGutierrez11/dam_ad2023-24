package org.example.probarpostman.service;

import org.example.probarpostman.model.Sala;
import org.example.probarpostman.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;
    // Otros métodos del servicio
    //Método para guardar una sala en la base de datos
    public Sala saveSala(Sala sala) {
        return salaRepository.save(sala);
    }
    //Método para obtener todas las salas de la base de datos
    public List<Sala> findAllSalas() {
        return salaRepository.findAll();
    }
    //Método para obtener una sala por su ID
    public Sala findSalaById(Long id) {
        return salaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Sala no encontrada con ID: " + id));
    }
    //Método para actualizar una sala por su ID
    public Sala updateSala(Long id, Sala updatedSala) {
        Sala existingSala = findSalaById(id);
        existingSala.setCapacidad(updatedSala.getCapacidad());
        return salaRepository.save(existingSala);
    }
    //Método para eliminar una sala por su ID
    public void deleteSalaById(Long id) {
        Sala sala = findSalaById(id);
        salaRepository.delete(sala);
    }




}
