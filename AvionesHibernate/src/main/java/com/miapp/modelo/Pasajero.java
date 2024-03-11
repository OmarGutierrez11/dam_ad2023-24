package com.miapp.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pasajero")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String nombre;
    private Date fechaNacimiento;
    private  boolean nino;
    @ManyToOne
    private Billete billete;
    @OneToOne(cascade ={ CascadeType.PERSIST,CascadeType.REMOVE})
    private Asiento asiento;

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Billete getBillete() {
        return billete;
    }

    public void setBillete(Billete billete) {
        this.billete = billete;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isNino() {
        return nino;
    }

}
