package com.miapp.modelo;

import javax.persistence.*;

@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String ciudad;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Vuelo vueloDestino;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Vuelo vueloOrigen;

    public Vuelo getVueloOrigen() {
        return vueloOrigen;
    }

    public void setVueloOrigen(Vuelo vueloOrigen) {
        this.vueloOrigen = vueloOrigen;
    }

    public Vuelo getVueloDestino() {
        return vueloDestino;
    }

    public void setVueloDestino(Vuelo vuelo) {
        this.vueloDestino = vuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
