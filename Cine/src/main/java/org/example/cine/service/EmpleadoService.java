package org.example.cine.service;

import org.example.cine.model.Empleado;
import org.example.cine.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    // Otros métodos del servicio
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }
    public Empleado findEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Empleado no encontrado con ID: " + id));
    }
    public Empleado updateEmpleado(Long id, Empleado updatedEmpleado) {
        Empleado existingEmpleado = findEmpleadoById(id);
        existingEmpleado.setNombre(updatedEmpleado.getNombre());
        existingEmpleado.setAntiguedad(updatedEmpleado.getAntiguedad());
        return empleadoRepository.save(existingEmpleado);
    }
    public void deleteEmpleadoById(Long id) {
        Empleado empleado = findEmpleadoById(id);
        empleadoRepository.delete(empleado);
    }
}
