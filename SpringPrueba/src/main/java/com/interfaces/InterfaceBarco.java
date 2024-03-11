package com.interfaces;

import com.modelo.Barco;

import java.util.List;

public interface InterfaceBarco  {
    Barco findById(Long id);
    List<Barco> findAll();
    Barco save(Barco barco);
    Barco update(Barco barco);
    void delete(Barco barco);
}
