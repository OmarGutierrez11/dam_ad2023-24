package org.example.probarpostman.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


    @Entity
    @Table(name = "sala")
    @Data
    @NoArgsConstructor
    public class Sala implements Serializable {
        //Atributos de la clase Sala con sus respectivas anotaciones para la base de datos
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "numSala")
        private int numSala;
        @Column(name = "capacidad")
        private int capacidad;
        @Column(name = "estado")
        private boolean estado;
        @Column (name ="tipoSala")
        private String tipoSala;

        //Relaciones de la clase Sala con las demas clases con sus respectivas anotaciones para la base de datos
        @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        private List<Sesion> listaSesiones;

        @ManyToOne
        private Cine cine;



    }


