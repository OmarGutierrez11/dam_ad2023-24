package org.example.omargutierrez.repository;

import org.example.omargutierrez.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {
    //ENCONTRAR PAGINAS POR NOMBRE
    List<Page> findByName(String name);
    //ENCONTRAR PAGINAS POR TIPO DE PAGINA
    List<Page> findByType(String type);
}
