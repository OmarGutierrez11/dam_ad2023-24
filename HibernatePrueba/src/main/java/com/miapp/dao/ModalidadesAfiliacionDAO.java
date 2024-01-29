package com.miapp.dao;

import com.miapp.modelo.ModalidadesAfiliacion;

import java.util.List;

public interface ModalidadesAfiliacionDAO {
    void addModalidad(ModalidadesAfiliacion modalidadesAfiliacion);
    ModalidadesAfiliacion getModalidad(Long id);
    List<ModalidadesAfiliacion> listaModalidades();
    void updateModalidad(ModalidadesAfiliacion modalidadesAfiliacion);
    void deleteModalidad(ModalidadesAfiliacion modalidadesAfiliacion);
}
