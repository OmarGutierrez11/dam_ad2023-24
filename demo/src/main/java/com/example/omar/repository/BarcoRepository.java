package com.example.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.omar.model.Barco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarcoRepository extends JpaRepository<Barco, Long> {
    List<Barco> findByNombre(@Param("nombre") String nombre);

    List<Barco> findByEsloraGreaterThan(@Param("eslora") Integer
                                                eslora);

    List<Barco> findByNombreOrderByCapacidadDesc(@Param("nombre") String nombre);

}

