package com.example.omar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.omar.model.Barco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BarcoRepository extends JpaRepository<Barco, Long> {
    //@Query("SELECT b FROM Barco b WHERE b.nombre = :nombre")
    List<Barco> findByNombre(@Param("nombre") String nombre);
   // @Query("SELECT b FROM Barco b WHERE b.eslora > :eslora")
    List<Barco> findByEsloraGreaterThan(@Param("eslora") Integer
                                                eslora);
   // @Query(value = "SELECT * FROM Barco b WHERE b.nombre = :nombre " +
       //     "ORDER BY b.capacidad DESC", nativeQuery = true) //SQL
    List<Barco> findByNombreOrderByCapacidadDesc(@Param("nombre") String nombre);

}

