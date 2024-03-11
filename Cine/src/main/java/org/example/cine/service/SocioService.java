package org.example.cine.service;

import org.example.cine.model.Socio;
import org.example.cine.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;
    // Otros métodos del servicio
    public Socio saveSocio(Socio socio) {
        return socioRepository.save(socio);
    }
    public Optional<Socio> getSocioById(Long id) {
        return socioRepository.findById(id);
    }
    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }
    public Socio updateSocio(Socio socio) {
        return socioRepository.save(socio);
    }
    public void deleteSocioById(Long id) {
        socioRepository.deleteById(id);
    }

}
