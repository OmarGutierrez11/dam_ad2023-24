package com.example.omar.service;

import com.example.omar.model.Amarre;
import com.example.omar.repository.AmarreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class AmarreService {
    // Inyectamos la instancia de AmarreRepository usando la anotación @Autowired
    @Autowired
    private AmarreRepository amarreRepository;
    // Método para guardar un amarre en la base de datos
    public Amarre saveAmarre(Amarre amarre) {
        // Llamamos al método save() de AmarreRepository, que guarda el amarre en la base de datos
        return amarreRepository.save(amarre);
    }
    // Método para obtener un amarre por su ID
    public Optional<Amarre> getAmarreById(Long id) {
        // Llamamos al método findById() de AmarreRepository,que busca un amarre en la base de datos por su ID
        return amarreRepository.findById(id);
    }
    // Método para obtener todos los amarres
    public List<Amarre> getAllAmarres() {
        // Llamamos al método findAll() de AmarreRepository,que devuelve todos los amarres en la base de datos
        return amarreRepository.findAll();
    }
    // Método para actualizar un amarre en la base de datos
    public Amarre updateAmarre(Amarre amarre) {
        // Llamamos al método save() de AmarreRepository, que actualiza el amarre en la base de datos
        // Si el amarre no existe, se creará uno nuevo con los datos proporcionados
        return amarreRepository.save(amarre);
    }
    // Método para eliminar un amarre por su ID
    public void deleteAmarreById(Long id) {
        // Llamamos al método deleteById() de AmarreRepository, que elimina un amarre en la base de datos por su ID
        amarreRepository.deleteById(id);
    }
}

