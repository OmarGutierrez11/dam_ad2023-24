package org.example.probarpostman.service;

import org.example.probarpostman.model.Sesion;
import org.example.probarpostman.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionService {
    @Autowired
    private SesionRepository sesionRepository;
    //Metodo para guardar una sesion en la base de datos
    public Sesion saveSesion(Sesion sesion) {
        return sesionRepository.save(sesion);
    }
    //Metodo para obtener todas las sesiones de la base de datos
    public List<Sesion> findAllSesiones() {
        return sesionRepository.findAll();
    }
    //Metodo para obtener una sesion por su ID
    public Sesion findSesionById(Long id) {
        return sesionRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Sesion no encontrada con ID: " + id));
    }
    //Metodo para actualizar una sesion por su ID
    public Sesion updateSesion(Long id, Sesion updatedSesion) {
        Sesion existingSesion = findSesionById(id);
        existingSesion.setPrecio(updatedSesion.getPrecio());
        existingSesion.setPrecio(updatedSesion.getPrecio());
        return sesionRepository.save(existingSesion);
    }
    //Metodo para eliminar una sesion por su ID
    public void deleteSesionById(Long id) {
        Sesion sesion = findSesionById(id);
        sesionRepository.delete(sesion);
    }


}
