package com.miapp.dao;

import com.miapp.modelo.Aeropuerto;
import com.miapp.modelo.Asiento;
import com.miapp.modelo.Vuelo;

import java.util.Date;

public interface LogicaVueloDAO {
    void creaVuelo737(Aeropuerto origen, Aeropuerto destino, Date fechaVuelo);

}
