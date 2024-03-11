package org.example.cine.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sala")
@Data
@NoArgsConstructor
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numSala")
    private int numSala;
    @Column(name = "capacidad")
    private int capacidad;
    @Column(name = "estado")
    private boolean estado;
    @Column (name ="tipoSala")
    private String tipoSala;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Sesion> listaSesiones;

    @ManyToOne
    private Cine cine;



}
