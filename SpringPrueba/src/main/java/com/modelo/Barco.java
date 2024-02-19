package com.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
@Entity
@Data
@NoArgsConstructor
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private int eslora;
    private int manga;
    private int capacidad;
    @OneToOne(mappedBy = "barco", cascade = CascadeType.ALL)
    private Amarre amarre;
}