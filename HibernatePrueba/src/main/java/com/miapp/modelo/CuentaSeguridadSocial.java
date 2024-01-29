package com.miapp.modelo;


import javax.persistence.*;

@Entity
@Table(name = "cuenta_seguridad_social")
public class CuentaSeguridadSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
}
