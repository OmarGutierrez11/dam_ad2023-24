package org.example.omargutierrez.cotroller;

import org.example.omargutierrez.model.Server;
import org.example.omargutierrez.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServerController {
    @Autowired
    private ServerService serverService;
    //CREAR UN NUEVO SERVIDOR
    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody Server server) {
        Server newServer = serverService.saveServer(server);
        return ResponseEntity.ok(newServer);
    }
    //OBTENER TODOS LOS SERVIDORES
    @GetMapping
    public ResponseEntity<List<Server>> getAllServers() {
        List<Server> servers = serverService.findAllServers();
        return ResponseEntity.ok(servers);
    }
    //OBTENER SERVIDOR EN CONCRETO POR SU ID
    @GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(Long id) {
        Server server = serverService.findServerById(id);
        return ResponseEntity.ok(server);
    }
    //OBTENER SERVIDOR POR SU IP
    @GetMapping("/ip/{ip}")
    public ResponseEntity<List<Server>> getServersByIp(@PathVariable String ip) {
        List<Server> servers = serverService.findAllServersByIp(ip);
        return ResponseEntity.ok(servers);
    }
    //OBTENER POR NOMBRE DE SERVIDOR
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Server>> getServersByName(@PathVariable String name) {
        List<Server> servers = serverService.findAllServersByName(name);
        return ResponseEntity.ok(servers);
    }
    //ACTUALZIAR UN SERVIDOR EN CONCRETO POR ID
    @PutMapping("/{id}")
    public ResponseEntity<Server> updateServer(@PathVariable Long id, @RequestBody Server updatedServer) {
        Server server = serverService.updateServer(id, updatedServer);
        return ResponseEntity.ok(server);
    }
    //ELIMINAR SERVIDOR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable Long id) {
        serverService.deleteServerById(id);
        return ResponseEntity.ok().build();
    }




}
