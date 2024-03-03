package org.example.probarpostman.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
public class Empleado implements Serializable {
    //Atributos de la clase Empleado con sus respectivas anotaciones para la base de datos y lombok
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "antiguedad")
    private int antiguedad;

    //Relacion de muchos a uno con la clase Cine para la base de datos
    @ManyToOne
    private Cine cine;


}
