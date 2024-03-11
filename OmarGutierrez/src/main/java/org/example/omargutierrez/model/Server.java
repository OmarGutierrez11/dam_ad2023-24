package org.example.omargutierrez.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "server")
@Data
@NoArgsConstructor
public class Server implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "memory")
    private double memory;
    @Column(name = "hd")
    private double hd;
    @Column(name = "estatus")
    private int estatus;

    //RELACIONES ENTRE ENTIDADES:
    //relacion uno a uno con la entidad "Site"
    @OneToOne
    private Site site;
}
