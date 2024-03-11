package com.modelo;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Regata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String lugar;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private int distancia;
    @ManyToMany(mappedBy = "regatas")
    private List<Barco> barcos;
}