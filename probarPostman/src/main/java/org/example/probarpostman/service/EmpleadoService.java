package org.example.probarpostman.service;

import org.example.probarpostman.model.Empleado;
import org.example.probarpostman.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    // Otros métodos del servicio
    //Método para guardar un empleado en la base de datos
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    //Metodo para obtener todos los empleados de la base de datos
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }
    //Método para obtener un empleado por su ID
    public Empleado findEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Empleado no encontrado con ID: " + id));
    }
    //Método para actualizar un empleado
    public Empleado updateEmpleado(Long id, Empleado updatedEmpleado) {
        Empleado existingEmpleado = findEmpleadoById(id);
        existingEmpleado.setNombre(updatedEmpleado.getNombre());
        existingEmpleado.setAntiguedad(updatedEmpleado.getAntiguedad());
        return empleadoRepository.save(existingEmpleado);
    }
    //Método para eliminar un empleado
    public void deleteEmpleadoById(Long id) {
        Empleado empleado = findEmpleadoById(id);
        empleadoRepository.delete(empleado);
    }
}
