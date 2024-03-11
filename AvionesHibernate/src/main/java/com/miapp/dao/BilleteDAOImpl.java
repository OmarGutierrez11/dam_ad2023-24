package com.miapp.dao;

import com.miapp.modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class BilleteDAOImpl implements  BilleteDAO{

    private SessionFactory sessionFactory;

    public BilleteDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    //METODO QUE CALCULA EL PRECIO FINAL DEL BILLETE DEPENDIENDO DE SI EL PASAJERO ASOCIADO ES UN NINO
    @Override
    public double calcularPrecioFinal(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Billete billete = obtenerInfoBillete(id);
        double precioFinal = 0;
        List<Pasajero> pasajeroBillete = infoPasajeroBillete(id);
        try {
            transaction = session.beginTransaction();
            for(Pasajero p : pasajeroBillete){
                if(p.isNino()){
                    precioFinal += (billete.getPrecioPasajero() * (billete.getDescuentoNinos()/100));
                }else {
                    precioFinal += billete.getPrecioPasajero();
                }
            }
            billete.setPrecioFinal(precioFinal);
            session.update(billete);
            transaction.commit();

        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }


        return billete.getPrecioFinal();
    }

    //METODO QUE DEVUELVE LA INFORMACION CONCRETA DE UN BILLETE POR SU ID
    @Override
    public Billete obtenerInfoBillete(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Billete billete;

        try {
            transaction = session.beginTransaction();
           billete = session.get(Billete.class,id);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }

        return billete;
    }

    //METODO QUE DEVUELVE LA INFORMACION DEL PASAJERO ASCOIADO A UN BILLETE POR SU ID
    @Override
    public List<Pasajero> infoPasajeroBillete(long id) {
        Billete billete = obtenerInfoBillete(id);
        List<Pasajero> pasajeros = billete.getPasajeros();
        return pasajeros;

    }

    @Override
    public void reasignarAsientosFamilia(Long id, String tipo, int fila) {

    }

    @Override
    public void creaBillete(Double precioPasajero, int descNinos, List<Pasajero> pasajeros) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Billete billete = new Billete();
        billete.setPrecioPasajero(precioPasajero);
        billete.setDescuentoNinos(descNinos);
        billete.setFechaEmite(new Date());
        try {
            transaction = session.beginTransaction();
            for(Pasajero p: pasajeros){
                billete.anadirPasajero(p);
            }
            session.save(billete);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }

    }
}
