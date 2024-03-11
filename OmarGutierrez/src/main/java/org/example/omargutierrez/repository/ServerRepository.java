package org.example.omargutierrez.repository;

import org.example.omargutierrez.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServerRepository extends JpaRepository<Server, Long> {
    //ENCONTRAR POR IP
    List<Server> findAllByIp(String ip);
    //ENCONTRAR POR NOMBRE
    List<Server> findAllByName(String name);
}
