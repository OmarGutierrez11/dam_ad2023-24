package com.example.omar.service;

import com.example.omar.model.Barco;
import com.example.omar.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BarcoService {
    @Autowired
    private BarcoRepository barcoRepository;
    // Guardar un barco
    public Barco saveBarco(Barco barco) {
        return barcoRepository.save(barco);
    }
    // Encontrar todos los barcos
    public List<Barco> findAllBarcos() {
        return barcoRepository.findAll();
    }
    // Encontrar un barco por ID
    public Barco findBarcoById(Long id) {
        return barcoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Barco no encontrado con ID: " + id));
    }
    // Actualizar un barco por ID
    public Barco updateBarco(Long id, Barco updatedBarco) {
        Barco existingBarco = findBarcoById(id);
        // Aquí se pueden agregar validaciones adicionales y lógica de actualización
        existingBarco.setNombre(updatedBarco.getNombre());
        existingBarco.setEslora(updatedBarco.getEslora());
        // ... (actualizar otros atributos)
        return barcoRepository.save(existingBarco);
    }
    // Eliminar un barco por ID
    public void deleteBarco(Long id) {
        Barco barco = findBarcoById(id);
        barcoRepository.delete(barco);
    }
}