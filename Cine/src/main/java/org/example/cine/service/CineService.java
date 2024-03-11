package org.example.cine.service;

import org.example.cine.model.Cine;
import org.example.cine.repository.CineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CineService {
    @Autowired
    private CineRepository cineRepository;
    // Otros métodos del servicio
    public Cine saveCine(Cine cine) {

        return cineRepository.save(cine);
    }
    public Optional<Cine> getCineById(Long id) {

        return cineRepository.findById(id);
    }
    public List<Cine> getAllCines() {

        return cineRepository.findAll();
    }

    public Cine updateCine(Cine cine) {

        return cineRepository.save(cine);
    }
    public void deleteCineById(Long id) {

        cineRepository.deleteById(id);
    }

}
