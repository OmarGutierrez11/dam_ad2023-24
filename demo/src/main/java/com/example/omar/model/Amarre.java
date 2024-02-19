package com.example.omar.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "amarre")
public class Amarre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Double longitud;
    private Double latitud;
    private String ubicacion;
    private String categoria;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barco_id")
    private Barco barco;
    // ... otros métodos y constructores si los necesitas
}
