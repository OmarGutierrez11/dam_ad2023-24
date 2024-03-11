package org.example.omargutierrez.repository;


import org.example.omargutierrez.model.Site;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {
    //BUSQUE DE UN SITE CON UN ESPACIO MAYOR QUE OTRO
   List<Site> findByTotalsizeGreaterThan(int size);
    //BUSQUE DE UN SITE CON UN ESPACIO MENOR QUE OTRO
    List<Site> findByTotalsizeLessThan(int size);
    //BUSQUE DE UN SITE CON UN ESPACIO TOTAL COMPRENDIDO ENTRE 2 ESPACIOS
    List<Site> findByTotalsizeBetween(int size1, int size2);
}
