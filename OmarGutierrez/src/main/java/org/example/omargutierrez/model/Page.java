package org.example.omargutierrez.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "page")
@Data
@NoArgsConstructor
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "creationDate")
    private Date creationDate;
    @Column(name = "modificationDate")
    private Date modificationDate;
    @Column(name = "size")
    private Integer size;

    //RELACIONES ENTRE ENTIDADES:
    //relacion muchos a uno con la entidad "Site"
    @ManyToOne
    private Site site;
    //relacion uno a muchos con la entidad "Visit"
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Visit> listaVisits;
}
