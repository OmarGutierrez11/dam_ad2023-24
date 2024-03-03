package org.example.probarpostman.repository;

import org.example.probarpostman.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
