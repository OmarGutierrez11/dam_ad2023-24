
package org.example.jaxbPrueba;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para prestamoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="prestamoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ISBN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codigoSocio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreSocio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apellidoSocio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaDevolucion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prestamoType", propOrder = {
    "isbn",
    "titulo",
    "codigoSocio",
    "nombreSocio",
    "apellidoSocio",
    "fechaDevolucion"
})
public class PrestamoType {

    @XmlElement(name = "ISBN", required = true)
    protected String isbn;
    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String codigoSocio;
    @XmlElement(required = true)
    protected String nombreSocio;
    @XmlElement(required = true)
    protected String apellidoSocio;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaDevolucion;

    /**
     * Obtiene el valor de la propiedad isbn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Define el valor de la propiedad isbn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISBN(String value) {
        this.isbn = value;
    }

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoSocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSocio() {
        return codigoSocio;
    }

    /**
     * Define el valor de la propiedad codigoSocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSocio(String value) {
        this.codigoSocio = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreSocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSocio() {
        return nombreSocio;
    }

    /**
     * Define el valor de la propiedad nombreSocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSocio(String value) {
        this.nombreSocio = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoSocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoSocio() {
        return apellidoSocio;
    }

    /**
     * Define el valor de la propiedad apellidoSocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoSocio(String value) {
        this.apellidoSocio = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDevolucion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Define el valor de la propiedad fechaDevolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDevolucion(XMLGregorianCalendar value) {
        this.fechaDevolucion = value;
    }

}
