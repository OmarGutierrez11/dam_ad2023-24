package com.miapp.modelo;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;
    private String correoE;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
    private List<Billete> billete = new ArrayList<>();

    public List<Billete> getBillete() {
        return billete;
    }

    public void setBillete(List<Billete> billete) {
        this.billete = billete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }





}
