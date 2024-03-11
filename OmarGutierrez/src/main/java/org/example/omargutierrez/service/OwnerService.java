package org.example.omargutierrez.service;

import org.example.omargutierrez.model.Owner;
import org.example.omargutierrez.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    //METODO PARA GUARDAR OWNERS
    public Owner saveOwner(Owner owner) {

        return ownerRepository.save(owner);
    }

    //METODO PARA ENCONTRAR INFO DE OWNERS POR SU ID
    public Owner findOwnerById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Owner no encontrado con ID: " + id));
    }

    //METODO PARA ENCONTRAR INFO DE TODOS LOS OWNERS
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }
    //METODO PARA ACTUALIZAR LA INFO DE UN OWNER SEGUN SU ID
    public Owner updateOwner(Long id, Owner updatedOwner) {
        Owner existingOwner = findOwnerById(id);
        existingOwner.setLocation(updatedOwner.getLocation());
        existingOwner.setTelefono(updatedOwner.getTelefono());
        return ownerRepository.save(existingOwner);
    }
    //METODO DE BORRADO DE OWNERS POR ID
    public void deleteOwnerById(Long id) {
        Owner owner = findOwnerById(id);
        ownerRepository.delete(owner);
    }
    //ENCONTAR OWNERS SEGUN LA LOCALIZACION
    public Owner findOwnerByLocation(String location) {
        return ownerRepository.findByLocation(location
        ).orElseThrow(() -> new RuntimeException("Owner no encontrado con location: " + location));
    }
    //ENCONTRAR OWNERS SEGUN EL TELEFONO
    public Owner findOwnerByTelefono(String telefono) {
        return ownerRepository.findByTelefono(telefono
        ).orElseThrow(() -> new RuntimeException("Owner no encontrado con telefono: " + telefono));
    }
    //ENCONTRAR OWNERS SEGUN SU NOMBRE
    public Owner findOwnerByNombre(String nombre) {
        return ownerRepository.findByNombre(nombre
        ).orElseThrow(() -> new RuntimeException("Owner no encontrado con nombre: " + nombre));
    }





}
