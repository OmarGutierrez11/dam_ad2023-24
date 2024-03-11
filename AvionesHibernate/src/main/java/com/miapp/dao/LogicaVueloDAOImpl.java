package com.miapp.dao;

import com.miapp.modelo.Aeropuerto;
import com.miapp.modelo.Asiento;
import com.miapp.modelo.Vuelo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Date;

public class LogicaVueloDAOImpl implements LogicaVueloDAO {
    private SessionFactory sessionFactory;

    public LogicaVueloDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void creaVuelo737(Aeropuerto origen, Aeropuerto destino, Date fechaVuelo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Vuelo vuelo737 = new Vuelo();
        int numAsiento = 0;
        int numFila = 0;
        vuelo737.setAeropuertoOrigen(origen);
        vuelo737.setAeropuertoDestino(destino);
        vuelo737.setFechaVuelo(new Date());
        origen.setVueloOrigen(vuelo737);
        destino.setVueloDestino(vuelo737);
        Asiento asiento;
        try {

            for (int i = 1; i <= 30; i++) {
                numFila = i;
                for (int j = 1; j <= 6; j++) {
                    asiento = new Asiento();
                    asiento.setFila(numFila);
                    numAsiento = j;
                    asignarLetraAsiento(asiento,numAsiento);
                    asiento.setTipo(asignarTipoAsiento(asiento));
                    transaction.commit();
                }
            }
        } catch (RuntimeException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    private void asignarLetraAsiento(Asiento asiento, int numAsiento){
        switch (numAsiento){
            case 1:
                asiento.setLetra("A");
                break;
            case 2:
                asiento.setLetra("B");
                break;
            case 3:
                asiento.setLetra("C");
                break;
            case 4:
                asiento.setLetra("D");
                break;
            case 5:
                asiento.setLetra("E");
                break;
            case 6:
                asiento.setLetra("F");
                break;
        }
    }

    private String asignarTipoAsiento(Asiento asiento){
        if(asiento.getFila() <= 5){
            return "Business";
        }else{
            return "Turista";
        }
    }

}
