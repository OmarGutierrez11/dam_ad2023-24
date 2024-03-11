package org.example.cine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "cine")
@Data
@NoArgsConstructor
public class Cine implements Serializable {

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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Sala> listaSalas;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Empleado> listaEmpleados;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Socio> listaSocios;


}
