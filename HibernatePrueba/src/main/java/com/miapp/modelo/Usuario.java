package com.miapp.modelo;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_seguridad_social_id", referencedColumnName = "id")
    private CuentaSeguridadSocial cuentaSeguridadSocial;


}
