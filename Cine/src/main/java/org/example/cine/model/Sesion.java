package org.example.cine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "sesion")
@Data
@NoArgsConstructor
public class Sesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fechaSesion")
    private String fechaSesion;
    @Column(name = "horaComienzo")
    private String horaComienzo;
    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    private Sala sala;
    @ManyToOne
    private Pelicula pelicula;






}
