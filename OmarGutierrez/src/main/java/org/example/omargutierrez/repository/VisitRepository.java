package org.example.omargutierrez.repository;

import org.example.omargutierrez.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    //BUSCAR POR IP
    List<Visit> findByIp(String ip);
}
