package com.example.omar.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "barcos")
@Data
@NoArgsConstructor
public class Barco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "eslora")
    private Double eslora;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "tipo")
    private String tipo;
    @OneToOne(mappedBy = "barco", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Amarre amarre;
    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "barco_regata",
            joinColumns = @JoinColumn(name = "barco_id"),
            inverseJoinColumns = @JoinColumn(name =
                    "regata_id"))
    private Set<Regata> regatas = new HashSet<>();
    public Barco(String nombre, Double eslora, Integer
            capacidad, String matricula, String tipo) {
        this.nombre = nombre;
        this.eslora = eslora;
        this.capacidad = capacidad;
        this.matricula = matricula;
        this.tipo = tipo;
    }
    public void addRegata(Regata regata) {
        regatas.add(regata);
        regata.getBarcos().add(this);
    }
    public void removeRegata(Regata regata) {
        regatas.remove(regata);
        regata.getBarcos().remove(this);
    }
}
