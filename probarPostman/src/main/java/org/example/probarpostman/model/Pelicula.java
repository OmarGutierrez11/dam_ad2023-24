package org.example.probarpostman.model;

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
    //Atributos de la clase Pelicula con sus respectivas anotaciones para la base de datos y lombok
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

    //Relacion de uno a muchos con la clase Sesion para poder tener una lista de sesiones asociadas a la pelicula
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Sesion> listaSesiones;


}
