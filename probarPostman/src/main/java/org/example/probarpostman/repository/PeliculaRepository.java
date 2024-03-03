package org.example.probarpostman.repository;

import org.example.probarpostman.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    List<Pelicula> findByNombre(@Param("nombre") String titulo);
    List<Pelicula> findByDuracionGreaterThan(@Param("duracion") Integer duracion);

}
