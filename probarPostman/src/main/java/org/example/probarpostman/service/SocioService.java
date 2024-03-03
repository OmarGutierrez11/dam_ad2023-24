package org.example.probarpostman.service;

import org.example.probarpostman.model.Socio;
import org.example.probarpostman.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;
    //Metodo para guardar un socio en la base de datos
    public  Socio saveSocio(Socio socio){
        return socioRepository.save(socio);
    }
    //Metodo para obtener todos los socios de la base de datos
    public List<Socio> findAllSocios(){
        return socioRepository.findAll();
    }
    //Metodo para obtener un socio por su id
    public Optional<Socio> getSocioById(Long id){
        return socioRepository.findById(id);
    }
    //Metodo para actualizar un socio por su id
    public Socio updateSocio(Long id, Socio socio){
        Socio existingSocio = findSocioById(id);
        existingSocio.setTelefono(socio.getTelefono());
        return socioRepository.save(existingSocio);
    }
    //Metodo para eliminar un socio por su id
    public void deleteSocioById(Long id){
        socioRepository.deleteById(id);
    }
    //Metodo para obtener un socio por su id
    public Socio findSocioById(Long id){
        return socioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Socio no encontrado con ID: " + id));
    }

}
