package org.example.cine.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.cine.model.Pelicula;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    List<Pelicula> findByNombre(@Param("nombre") String titulo);
    List<Pelicula> findByDuracionGreaterThan(@Param("duracion") Integer duracion);

}
