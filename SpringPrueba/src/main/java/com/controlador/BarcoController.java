package com.controlador;

import com.modelo.Amarre;
import com.modelo.Barco;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BarcoController {
    public static void main(String[] args) {
        Barco barco = new Barco();
        barco.setNombre("Barco Ejemplo");
        barco.setTipo("Velero");
        barco.setEslora(10);
        barco.setManga(3);
        barco.setCapacidad(6);
        Amarre amarre = new Amarre();
        amarre.setUbicacion("A-1");
        amarre.setPrecio(1500.0);
        amarre.setProfundidad(5);
        amarre.setLongitud(12);
        amarre.setElectricidad(true);
        barco.setAmarre(amarre);
        amarre.setBarco(barco);


    }
}
