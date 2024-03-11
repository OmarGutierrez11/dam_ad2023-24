package org.example.omargutierrez.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "owner")
@Data
@NoArgsConstructor
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "location")
    private String location;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;

    //RELACION ENTRE ENTIDADES:
    //relacion de muchos a muchos con la entidad "Site"
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Site> listaSites;







}
