package org.example.cine.service;

import org.example.cine.model.Sesion;
import org.example.cine.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
    @Autowired
    private SesionRepository sesionRepository;

    public Sesion saveSesion(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    public List<Sesion> findAllSesiones() {
        return sesionRepository.findAll();
    }

    public Sesion findSesionById(Long id) {
        return sesionRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Sesion no encontrada con ID: " + id));
    }
    public Sesion updateSesion(Long id, Sesion updatedSesion) {
        Sesion existingSesion = findSesionById(id);
        existingSesion.setPrecio(updatedSesion.getPrecio());
        existingSesion.setPrecio(updatedSesion.getPrecio());
        return sesionRepository.save(existingSesion);
    }

    public void deleteSesionById(Long id) {
        Sesion sesion = findSesionById(id);
        sesionRepository.delete(sesion);
    }


}
