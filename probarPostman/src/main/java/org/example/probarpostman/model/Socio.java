package org.example.probarpostman.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "socio")
@Data
@NoArgsConstructor
public class Socio implements Serializable {
    //Atributos de la clase Socio
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    //Relacion de uno a uno con la tabla Socio
    @ManyToOne
    private Socio socio;
}
