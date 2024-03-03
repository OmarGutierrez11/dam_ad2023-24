package org.example.probarpostman.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "sesion")
@Data
@NoArgsConstructor
public class Sesion implements Serializable {
    //Atributos de la clase Sesion con sus respectivas anotaciones para la base de datos y lombok
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fechaSesion")
    private String fechaSesion;
    @Column(name = "horaComienzo")
    private String horaComienzo;
    @Column(name = "precio")
    private Double precio;

    //Relaciones de la clase Sesion con las clases Sala y Pelicula con sus respectivas anotaciones para la base de datos
    @ManyToOne
    private Sala sala;
    @ManyToOne
    private Pelicula pelicula;






}
