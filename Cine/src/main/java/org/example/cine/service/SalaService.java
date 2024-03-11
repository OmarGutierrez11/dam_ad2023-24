package org.example.cine.service;

import org.example.cine.model.Sala;
import org.example.cine.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;
    // Otros métodos del servicio
    public Sala saveSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public List<Sala> findAllSalas() {
        return salaRepository.findAll();
    }

    public Sala findSalaById(Long id) {
        return salaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Sala no encontrada con ID: " + id));
    }

    public Sala updateSala(Long id, Sala updatedSala) {
        Sala existingSala = findSalaById(id);
        existingSala.setCapacidad(updatedSala.getCapacidad());
        return salaRepository.save(existingSala);
    }

    public void deleteSalaById(Long id) {
        Sala sala = findSalaById(id);
        salaRepository.delete(sala);
    }




}
