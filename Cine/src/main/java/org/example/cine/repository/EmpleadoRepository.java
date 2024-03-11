package org.example.cine.repository;

import org.example.cine.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findByNombre(@Param("nombre") String nombre);
    List<Empleado> findByAntiguedadGreaterThan(@Param("antiguedad") Integer antiguedad);
    List<Empleado> findByNombreOrderByAntiguedadDesc(@Param("nombre") String nombre);

}
