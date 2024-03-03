package org.example.probarpostman.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "cine")
@Data
@NoArgsConstructor
public class Cine implements Serializable {
    //Atributos de la clase Cine con sus respectivas anotaciones para la base de datos y lombok
    //para el manejo de los mismos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "anoFundacion")
    private String anoFundacion;
    @Column(name = "valoracion")
    private Double valoracion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    //Relaciones de la clase Cine con las clases Sala, Empleado y Socio con sus respectivas anotaciones
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Sala> listaSalas;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Empleado> listaEmpleados;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Socio> listaSocios;


}
