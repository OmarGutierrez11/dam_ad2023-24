package com.miapp.dao;

import com.miapp.modelo.Direccion;

import java.util.List;

public interface DireccionDAO {
    void addDireccion (Direccion direccion);
    Direccion getDireccion(Long id);
    List<Direccion> listaDirecciones();
    void deleteDireccion(Direccion direccion);
    void updateDireccion(Direccion direccion);
}
