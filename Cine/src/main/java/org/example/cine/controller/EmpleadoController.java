package org.example.cine.controller;

import org.example.cine.model.Empleado;
import org.example.cine.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado newEmp =  empleadoService.saveEmpleado(empleado);
        return ResponseEntity.ok(newEmp);
    }
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.findAllEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Empleado empleado = empleadoService.findEmpleadoById(id);
        return ResponseEntity.ok(empleado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado updatedEmpleado) {
        Empleado empleado = empleadoService.updateEmpleado(id, updatedEmpleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleadoById(id);
        return ResponseEntity.ok().build();
    }
}
