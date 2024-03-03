package org.example.probarpostman.repository;

import org.example.probarpostman.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findByNombre(@Param("nombre") String nombre);
    List<Empleado> findByAntiguedadGreaterThan(@Param("antiguedad") Integer antiguedad);
    List<Empleado> findByNombreOrderByAntiguedadDesc(@Param("nombre") String nombre);

}
