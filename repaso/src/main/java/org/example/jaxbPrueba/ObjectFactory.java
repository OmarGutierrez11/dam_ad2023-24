
package org.example.jaxbPrueba;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.jaxbPrueba package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.jaxbPrueba
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Biblioteca }
     * 
     */
    public Biblioteca createBiblioteca() {
        return new Biblioteca();
    }

    /**
     * Create an instance of {@link SocioType }
     * 
     */
    public SocioType createSocioType() {
        return new SocioType();
    }

    /**
     * Create an instance of {@link LibroType }
     * 
     */
    public LibroType createLibroType() {
        return new LibroType();
    }

    /**
     * Create an instance of {@link Biblioteca.Libros }
     * 
     */
    public Biblioteca.Libros createBibliotecaLibros() {
        return new Biblioteca.Libros();
    }

    /**
     * Create an instance of {@link Biblioteca.Socios }
     * 
     */
    public Biblioteca.Socios createBibliotecaSocios() {
        return new Biblioteca.Socios();
    }

    /**
     * Create an instance of {@link Biblioteca.Prestamos }
     * 
     */
    public Biblioteca.Prestamos createBibliotecaPrestamos() {
        return new Biblioteca.Prestamos();
    }

    /**
     * Create an instance of {@link PrestamoType }
     * 
     */
    public PrestamoType createPrestamoType() {
        return new PrestamoType();
    }

    /**
     * Create an instance of {@link SocioType.LibrosPrestados }
     * 
     */
    public SocioType.LibrosPrestados createSocioTypeLibrosPrestados() {
        return new SocioType.LibrosPrestados();
    }

    /**
     * Create an instance of {@link LibroType.FechaDevolucion }
     * 
     */
    public LibroType.FechaDevolucion createLibroTypeFechaDevolucion() {
        return new LibroType.FechaDevolucion();
    }

}
