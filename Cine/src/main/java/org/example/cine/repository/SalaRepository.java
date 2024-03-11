package org.example.cine.repository;

import org.example.cine.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findByCapacidadGreaterThan(@Param("capacidad") Integer capacidad);

}
