package com.interfaces;

import com.modelo.Regata;

import java.util.List;

public interface InterfaceRegata {
    Regata findById(Long id);
    List<Regata> findAll();
    Regata save(Regata regata);
    Regata update(Regata regata);
    void delete(Regata regata);
}
