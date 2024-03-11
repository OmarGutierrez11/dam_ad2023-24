package com.miapp.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="billete")
public class Billete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private Date fechaEmite;
    private double precioPasajero;
    private double descuentoNinos;
    private double precioFinal;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "billete")
    private List<Pasajero> pasajeros = new ArrayList<>();


    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioPasajero() {
        return precioPasajero;
    }

    public void setPrecioPasajero(double precioPasajero) {
        this.precioPasajero = precioPasajero;
    }

    public Date getFechaEmite() {
        return fechaEmite;
    }

    public void setFechaEmite(Date fechaEmite) {
        this.fechaEmite = fechaEmite;
    }

    public double getDescuentoNinos() {
        return descuentoNinos;
    }

    public void setDescuentoNinos(double descuentoNinos) {
        this.descuentoNinos = descuentoNinos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
