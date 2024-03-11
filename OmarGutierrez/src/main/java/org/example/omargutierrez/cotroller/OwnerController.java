package org.example.omargutierrez.cotroller;

import org.example.omargutierrez.model.Owner;
import org.example.omargutierrez.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    //CREACION DE UN NUEVO OWNER
    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        Owner newOwner = ownerService.saveOwner(owner);
        return ResponseEntity.ok(newOwner);
    }
    //LISTADO DE LA INFO DE TODOS LOS OWNERS
    @GetMapping
    public ResponseEntity<List<Owner>> getAllOwners() {
        List<Owner> owners = ownerService.findAllOwners();
        return ResponseEntity.ok(owners);
    }
    //LISTADO DE LA INFO DE UN OWNER BUSCANDOLO POR SU ID
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(Long id) {
        Owner owner = ownerService.findOwnerById(id);
        return ResponseEntity.ok(owner);
    }
    //LISTADO DE LA INFO DE LOS OWNER SEGUN SU LOCALIZACION
    @GetMapping("/{location}")
    public ResponseEntity<Owner> getOwnerByLocation(String location) {
        Owner owner = ownerService.findOwnerByLocation(location);
        return ResponseEntity.ok(owner);
    }
    //OBTENER INFO DE UN OWNER BUSCANDOLO POR SU TLF
    @GetMapping("/{telefono}")
    public ResponseEntity<Owner> getOwnerByTelefono(String telefono) {
        Owner owner = ownerService.findOwnerByTelefono(telefono);
        return ResponseEntity.ok(owner);
    }
    //OBTENCION DE UN OWNER POR NOMBRE
    @GetMapping("/{nombre}")
    public ResponseEntity<Owner> getOwnerByNombre(String nombre) {
        Owner owner = ownerService.findOwnerByNombre(nombre);
        return ResponseEntity.ok(owner);
    }
    //ACTUALIZACION DE INFO DE OWNER SEGUN EL ID DEL OWNER QUE QUERAMOS ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner updatedOwner) {
        Owner owner = ownerService.updateOwner(id, updatedOwner);
        return ResponseEntity.ok(owner);
    }
    //BORRADO DE UN OWNER EN CONCRETO SEGUN SU ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwnerById(id);
        return ResponseEntity.ok().build();
    }
}
