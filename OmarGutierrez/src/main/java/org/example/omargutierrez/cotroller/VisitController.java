package org.example.omargutierrez.cotroller;

import org.example.omargutierrez.model.Visit;
import org.example.omargutierrez.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {
    @Autowired
    private VisitService visitService;
    //CREAR VISITA NUEVA
    @PostMapping
    public ResponseEntity<Visit> createVisit(@RequestBody Visit visit) {
        Visit newVisit = visitService.saveVisit(visit);
        return ResponseEntity.ok(newVisit);
    }
    //OBTENER REGISTRO COMPLETO DE TODAS LAS VISITAS
    @GetMapping
    public ResponseEntity<List<Visit>> getAllVisits() {
        List<Visit> visits = visitService.findAllVisits();
        return ResponseEntity.ok(visits);
    }
    //OBTENER CUENTA TOTAL DE VISITAS REGISTRADAS
    @GetMapping("/count")
    public ResponseEntity<Long> countVisits() {
        long count = visitService.countVisits();
        return ResponseEntity.ok(count);
    }
    //OBTENER UNA VISITA POR SU ID
    @GetMapping("/{id}")
    public ResponseEntity<Visit> getVisitById(Long id) {
        Visit visit = visitService.findVisitById(id);
        return ResponseEntity.ok(visit);
    }
    //OBTENER UNA VISITA POR SU IP
    @GetMapping("/ip/{ip}")
    public ResponseEntity<List<Visit>> getVisitsByIp(@PathVariable String ip) {
        List<Visit> visits = visitService.findVisitsByIp(ip);
        return ResponseEntity.ok(visits);
    }
    //ACTUALIZAR INFO DE UNA VISITA POR SU ID
    @PutMapping("/{id}")
    public ResponseEntity<Visit> updateVisit(@PathVariable Long id, @RequestBody Visit updatedVisit) {
        Visit visit = visitService.updateVisit(id, updatedVisit);
        return ResponseEntity.ok(visit);
    }
    //ELIMINAR VISITA POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteVisitById(id);
        return ResponseEntity.ok().build();
    }
    //ELIMINAR REGISTRO COMPLETO DE VISITAS
    @DeleteMapping
    public ResponseEntity<Void> deleteAllVisits() {
        visitService.deleteAllVisits();
        return ResponseEntity.ok().build();
    }

}
