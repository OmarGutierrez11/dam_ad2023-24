package org.example;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.example.excepciones.SocioNoExisteException;
import org.example.jaxbPrueba.Biblioteca;
import org.example.jaxbPrueba.ObjectFactory;
import org.example.jaxbPrueba.SocioType;
import org.example.modelo.MetodosBiblioteca;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MetodosBiblioteca metodos = new MetodosBiblioteca();
        File archivoXMLentrada = new File("BIBLIOTECA.xml");
        File archivoXMLsalida = new File("bibliotecaSALIDA.xml");

        try {
            // Unmarshalizo
            JAXBElement elemento = metodos.unmarshalizar(archivoXMLentrada);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
