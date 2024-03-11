package com.interfaces;

import com.modelo.Amarre;

import java.util.List;

public interface InterfaceAmarre {
    Amarre findById(Long id);
    List<Amarre> findAll();
    Amarre save(Amarre amarre);
    Amarre update(Amarre amarre);
    void delete(Amarre amarre);
}
