package org.example.cine.repository;

import org.example.cine.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocioRepository extends JpaRepository<Socio, Long> {
    List<Socio> findByNombre(String nombre);


}
