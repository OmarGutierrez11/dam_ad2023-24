package org.example.probarpostman.controller;

import org.example.probarpostman.model.Empleado;
import org.example.probarpostman.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    //Metodo para crear un empleado en la base de datos con el metodo POST en la url /api/empleados
    // y el cuerpo de la peticion es un objeto de tipo Empleado en formato JSON
    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado newEmp =  empleadoService.saveEmpleado(empleado);
        return ResponseEntity.ok(newEmp);
    }
    //Metodo para obtener todos los empleados de la base de datos con el metodo GET en la url /api/empleados

    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.findAllEmpleados();
        return ResponseEntity.ok(empleados);
    }
    //Metodo para obtener un empleado por su id con el metodo GET en la url /api/empleados/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Empleado empleado = empleadoService.findEmpleadoById(id);
        return ResponseEntity.ok(empleado);
    }
    //Metodo para actualizar un empleado por su id con el metodo PUT en la url /api/empleados/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado updatedEmpleado) {
        Empleado empleado = empleadoService.updateEmpleado(id, updatedEmpleado);
        return ResponseEntity.ok(empleado);
    }
    //Metodo para eliminar un empleado por su id con el metodo DELETE en la url /api/empleados/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleadoById(id);
        return ResponseEntity.ok().build();
    }
}
