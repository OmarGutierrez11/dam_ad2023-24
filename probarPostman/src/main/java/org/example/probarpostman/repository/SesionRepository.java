package org.example.probarpostman.repository;

import org.example.probarpostman.model.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long>{

}
