package org.example.cine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Data
@NoArgsConstructor
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "duracion")
    private int duracion;
    @Column(name = "genero")
    private String genero;
    @Column(name = "anoLanzamiento")
    private String anoLanzamiento;



    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Sesion> listaSesiones;
}
