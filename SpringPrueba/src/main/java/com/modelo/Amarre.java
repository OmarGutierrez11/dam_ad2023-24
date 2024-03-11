package com.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
@Data
@NoArgsConstructor
public class Amarre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ubicacion;
    private double precio;
    private int profundidad;
    private int longitud;
    private boolean electricidad;
    @OneToOne
    private Barco barco;
}
