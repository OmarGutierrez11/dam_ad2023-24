package org.example.omargutierrez.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "visit")
@Data
@NoArgsConstructor
public class Visit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "date")
    private Date date;
    @Column(name = "hour")
    private double hour;
    @Column(name = "bandwidth")
    private int bandwidth;

    //RELACIONES ENTRE ENTIDADES:
    //relacion muchos a uno con la entidad "Page"
    @ManyToOne
    private Page page;
}
