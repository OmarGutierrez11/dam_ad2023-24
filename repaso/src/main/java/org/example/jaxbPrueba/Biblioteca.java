
package org.example.jaxbPrueba;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="libros"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element name="libro" type="{}libroType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="socios"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element name="socio" type="{}socioType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="prestamos"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element name="prestamo" type="{}prestamoType"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "libros",
    "socios",
    "prestamos"
})
@XmlRootElement(name = "biblioteca")
public class Biblioteca {

    @XmlElement(required = true)
    protected Biblioteca.Libros libros;
    @XmlElement(required = true)
    protected Biblioteca.Socios socios;
    @XmlElement(required = true)
    protected Biblioteca.Prestamos prestamos;

    /**
     * Obtiene el valor de la propiedad libros.
     * 
     * @return
     *     possible object is
     *     {@link Biblioteca.Libros }
     *     
     */
    public Biblioteca.Libros getLibros() {
        return libros;
    }

    /**
     * Define el valor de la propiedad libros.
     * 
     * @param value
     *     allowed object is
     *     {@link Biblioteca.Libros }
     *     
     */
    public void setLibros(Biblioteca.Libros value) {
        this.libros = value;
    }

    /**
     * Obtiene el valor de la propiedad socios.
     * 
     * @return
     *     possible object is
     *     {@link Biblioteca.Socios }
     *     
     */
    public Biblioteca.Socios getSocios() {
        return socios;
    }

    /**
     * Define el valor de la propiedad socios.
     * 
     * @param value
     *     allowed object is
     *     {@link Biblioteca.Socios }
     *     
     */
    public void setSocios(Biblioteca.Socios value) {
        this.socios = value;
    }

    /**
     * Obtiene el valor de la propiedad prestamos.
     * 
     * @return
     *     possible object is
     *     {@link Biblioteca.Prestamos }
     *     
     */
    public Biblioteca.Prestamos getPrestamos() {
        return prestamos;
    }

    /**
     * Define el valor de la propiedad prestamos.
     * 
     * @param value
     *     allowed object is
     *     {@link Biblioteca.Prestamos }
     *     
     */
    public void setPrestamos(Biblioteca.Prestamos value) {
        this.prestamos = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded"&gt;
     *         &lt;element name="libro" type="{}libroType"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "libro"
    })
    public static class Libros {

        @XmlElement(required = true)
        protected List<LibroType> libro;

        /**
         * Gets the value of the libro property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the libro property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLibro().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LibroType }
         * 
         * 
         */
        public List<LibroType> getLibro() {
            if (libro == null) {
                libro = new ArrayList<LibroType>();
            }
            return this.libro;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded"&gt;
     *         &lt;element name="prestamo" type="{}prestamoType"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "prestamo"
    })
    public static class Prestamos {

        @XmlElement(required = true)
        protected List<PrestamoType> prestamo;

        /**
         * Gets the value of the prestamo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the prestamo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrestamo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PrestamoType }
         * 
         * 
         */
        public List<PrestamoType> getPrestamo() {
            if (prestamo == null) {
                prestamo = new ArrayList<PrestamoType>();
            }
            return this.prestamo;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded"&gt;
     *         &lt;element name="socio" type="{}socioType"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "socio"
    })
    public static class Socios {

        @XmlElement(required = true)
        protected List<SocioType> socio;

        /**
         * Gets the value of the socio property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the socio property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSocio().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SocioType }
         * 
         * 
         */
        public List<SocioType> getSocio() {
            if (socio == null) {
                socio = new ArrayList<SocioType>();
            }
            return this.socio;
        }

    }

}
