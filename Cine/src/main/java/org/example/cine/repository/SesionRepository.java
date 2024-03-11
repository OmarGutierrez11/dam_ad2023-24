package org.example.cine.repository;

import org.example.cine.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long>{
    List<Sesion> findByHoraInicio(String horaInicio);
    List<Sesion> findByPrecioGreaterThan(Integer precio);
}
