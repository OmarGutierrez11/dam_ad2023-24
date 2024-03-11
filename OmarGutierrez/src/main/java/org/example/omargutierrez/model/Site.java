package org.example.omargutierrez.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "site")
@Data
@NoArgsConstructor
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "url")
    private String url;
    @Column(name = "description")
    private String description;
    @Column(name = "totalsize")
    private double totalsize;
    @Column(name = "totalFiles")
    private int totalFiles;

    //RELACIONES ENTRE ENTIDADES:
    //relacion muchos a muchos con la entidad "Owner"
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Owner> listaOwners;
    //relacion uno a uno con la entidad "Server"
    @OneToOne
    private Server server;
    //relacion uno a muchos con la entidad "Page"
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Page> listaPages;
}
