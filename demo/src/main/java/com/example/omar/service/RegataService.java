package com.example.omar.service;

import com.example.omar.model.Regata;
import com.example.omar.repository.RegataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RegataService {
    // Inyectamos la instancia de RegataRepository usando la anotación @Autowired
    @Autowired
    private RegataRepository regataRepository;
    // Método para guardar una regata en la base de datos
    public Regata saveRegata(Regata regata) {
        // Llamamos al método save() de RegataRepository, que guarda la regata en la base de datos
        return regataRepository.save(regata);
    }
    // Método para obtener una regata por su ID
    public Optional<Regata> getRegataById(Long id) {
        // Llamamos al método findById() de RegataRepository,que busca una regata en la base de datos por su ID
        return regataRepository.findById(id);
    }
    // Método para obtener todas las regatas
    public List<Regata> getAllRegatas() {
        // Llamamos al método findAll() de RegataRepository,que devuelve todas las regatas en la base de datos
        return regataRepository.findAll();
    }
    // Método para actualizar una regata en la base de datos
    public Regata updateRegata(Regata regata) {
        // Llamamos al método save() de RegataRepository, que actualiza la regata en la base de datos
        // Si la regata no existe, se creará una nueva con los datos proporcionados
        return regataRepository.save(regata);
    }
    // Método para eliminar una regata por su ID
    public void deleteRegataById(Long id) {
        // Llamamos al método deleteById() de RegataRepository, que elimina una regata en la base de datos por su ID
        regataRepository.deleteById(id);
    }
}