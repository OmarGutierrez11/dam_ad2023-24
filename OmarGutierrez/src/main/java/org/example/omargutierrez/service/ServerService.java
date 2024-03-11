package org.example.omargutierrez.service;

import org.example.omargutierrez.model.Server;
import org.example.omargutierrez.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {
    @Autowired
    private ServerRepository serverRepository;
    //GUARDAR SERVER
    public Server saveServer(Server server) {

        return serverRepository.save(server);
    }
    //BUSCAR POR ID
    public Server findServerById(Long id) {
        return serverRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Server no encontrado con ID: " + id));
    }
    //BUSCAR TODOS
    public List<Server> findAllServers() {
        return serverRepository.findAll();
    }
    //BUSCAR POR IP
    public List<Server> findAllServersByIp(String ip) {
        return serverRepository.findAllByIp(ip);
    }
    //BUSCAR POR NOMBRE
    public List<Server> findAllServersByName(String name) {
        return serverRepository.findAllByName(name);
    }
    //ACTUALIZAR SERVER CONCRETO SEGUN IP
    public Server updateServer(Long id, Server updatedServer) {
        Server existingServer = findServerById(id);
        existingServer.setIp(updatedServer.getIp());
        existingServer.setName(updatedServer.getName());
        return serverRepository.save(existingServer);
    }
    //BORRADO DE SERVER SEGUN IP
    public void deleteServerById(Long id) {
        Server server = findServerById(id);
        serverRepository.delete(server);
    }



}
