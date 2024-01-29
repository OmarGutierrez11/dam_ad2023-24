package com.miapp.modelo;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "modalidadesAfiliacion")
public class ModalidadesAfiliacion  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
