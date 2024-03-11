package com.miapp.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private Date fechaVuelo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vuelo")
    private List<Asiento> asientos = new ArrayList<>();
    @OneToOne
    private Aeropuerto aeropuertoOrigen;
    @OneToOne
    private Aeropuerto aeropuertoDestino;

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuerto) {
        this.aeropuertoOrigen = aeropuerto;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
