/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.modelo;


import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.example.excepciones.SocioNoExisteException;
import org.example.jaxbPrueba.Biblioteca;
import org.example.jaxbPrueba.SocioType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.math.BigInteger;

/**
 *
 * @author Pablo Herrero
 */
public interface InterfaceBiblioteca {

    public JAXBElement unmarshalizar(File ficheroXML) throws JAXBException;

    public void marshalizar(JAXBElement jaxbElement, File archivoSalida) throws JAXBException;
    
    public void aniadirSocio(Biblioteca biblioteca, String codigoSocio, String nombre, String apellido1, String apellido2, BigInteger telefono, String isbn, String titulo, XMLGregorianCalendar fechaDevolucion);

    public SocioType buscarSocio(Biblioteca biblioteca, String codigoSocio, BigInteger telefono) throws SocioNoExisteException;
    
    public boolean borrarPrestamosSocio(Biblioteca biblioteca, SocioType socioABorrar) throws SocioNoExisteException;
    
    public boolean renovarPrestamosSocio(Biblioteca biblioteca, String codigoSocio) throws SocioNoExisteException;
}
