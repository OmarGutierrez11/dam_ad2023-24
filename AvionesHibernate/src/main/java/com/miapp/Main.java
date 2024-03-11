package com.miapp;

import com.miapp.dao.BilleteDAOImpl;
import com.miapp.modelo.*;
import com.miapp.util.HibernateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[]args){
        //CREACION DE BILLETE
        Billete billete1 = new Billete();
        billete1.setPrecioPasajero(167.65);
        billete1.setDescuentoNinos(7.5);
        billete1.setFechaEmite(new Date());

        //CREACION DE CLIENTE
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Omar");
        cliente1.setCorreoE("omargg17@educastur.es");

        //CREACION DE PASAJERO
        Pasajero pasajero1 = new Pasajero();
        pasajero1.setDni("34295773Z");
        pasajero1.setNombre("Omar");
        String fechaS = "24/11/2003";
        SimpleDateFormat simpleDateFormater = new SimpleDateFormat(fechaS);
        Date fechaNac = simpleDateFormater.get2DigitYearStart();
        pasajero1.setFechaNacimiento(fechaNac);

        //CREACION DE ASIENTO
        Asiento asiento1 = new Asiento();
        asiento1.setFila(1);
        asiento1.setLetra("A");
        asiento1.setTipo("Turista");

        //ASIGNACION DE ASIENTOS
        pasajero1.setAsiento(asiento1);
        asiento1.setPasajero(pasajero1);

        //ASIGNACION DE BILLETE A PASAJERO
        billete1.anadirPasajero(pasajero1);

        //CREACION DE VUELOS
        Vuelo vuelo1 = new Vuelo();
         fechaS = "05/02/2024";
         simpleDateFormater = new SimpleDateFormat(fechaS);
        Date fechaVue = simpleDateFormater.get2DigitYearStart();
        vuelo1.setFechaVuelo(fechaVue);

        //CREACION DE AEROPUERTOS
        Aeropuerto aeropuerto1 = new Aeropuerto();
        aeropuerto1.setCiudad("Pola de Laviana");
        Aeropuerto aeropuerto2 = new Aeropuerto();
        aeropuerto2.setCiudad("Cabanaquinta");
        Aeropuerto aeropuerto3 = new Aeropuerto();
        aeropuerto3.setCiudad("Suares");
        Aeropuerto aeropuerto4 = new Aeropuerto();
        aeropuerto4.setCiudad("Entralgo");

        //ASIGNACION DE AEROPUERTO A LOS VUELOS
        vuelo1.setAeropuertoOrigen(aeropuerto1);
        aeropuerto1.setVueloOrigen(vuelo1);
        vuelo1.setAeropuertoDestino(aeropuerto2);
        aeropuerto2.setVueloDestino(vuelo1);












    }


}
