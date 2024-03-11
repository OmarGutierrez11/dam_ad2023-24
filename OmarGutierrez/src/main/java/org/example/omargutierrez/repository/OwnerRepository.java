package org.example.omargutierrez.repository;

import org.example.omargutierrez.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    //METODO QUE BUSCARA EL OWNER POR SU TLF
    Optional<Owner> findByTelefono(String telefono);
    //METODO QUE BUSCARA EL OWNER POR SU LOCALIZACION
    Optional<Owner> findByLocation(String location);
    //METODO QUE BUSCARA EL OWNER POR SU NOMBRE
    Optional<Owner> findByNombre(String nombre);

}
