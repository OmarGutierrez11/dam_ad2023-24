package org.example.omargutierrez.service;

import org.example.omargutierrez.model.Visit;
import org.example.omargutierrez.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;
    //GUARDADO
    public Visit saveVisit(Visit visit) {

        return visitRepository.save(visit);
    }
    //BUSQUEDA POR ID
    public Visit findVisitById(Long id) {
        return visitRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Page no encontrado con ID: " + id));
    }
    //BUSQUEDA DE TODAS LAS VISITAS
    public List<Visit> findAllVisits() {
        return visitRepository.findAll();
    }
    //ACTUALIZACION DE UNA VISITA POR ID
    public Visit updateVisit(Long id, Visit updatedVisit) {
        Visit existingVisit = findVisitById(id);
        existingVisit.setIp(updatedVisit.getIp());
        return visitRepository.save(existingVisit);
    }
    //BORRADO POR ID
    public void deleteVisitById(Long id) {
        Visit visit = findVisitById(id);
        visitRepository.delete(visit);
    }
    //BORRADO COMPLETO DE LAS VISITAS REGISTRADAS
    public void deleteAllVisits() {
        visitRepository.deleteAll();
    }
    //CUENTA TOTAL DE VISITAS REGISTRADAS
    public long countVisits() {
        return visitRepository.count();
    }
    //BUSQUE DE UNA VISITA POR SU IP
    public List<Visit> findVisitsByIp(String ip) {
        return visitRepository.findByIp(ip);
    }






}
