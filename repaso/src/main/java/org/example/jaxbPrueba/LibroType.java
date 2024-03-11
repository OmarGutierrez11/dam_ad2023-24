
package org.example.jaxbPrueba;

import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para libroType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="libroType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ISBN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numeroPaginas" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="fechaPublicacion" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="prestadoSiNo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="No"/&gt;
 *               &lt;enumeration value="Si"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="fechaDevolucion"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
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
@XmlType(name = "libroType", propOrder = {
    "isbn",
    "titulo",
    "autor",
    "numeroPaginas",
    "fechaPublicacion",
    "prestadoSiNo",
    "fechaDevolucion"
})
public class LibroType {

    @XmlElement(name = "ISBN", required = true)
    protected String isbn;
    @XmlElement(required = true)
    protected String titulo;
    @XmlElement(required = true)
    protected String autor;
    @XmlElement(required = true)
    protected BigInteger numeroPaginas;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPublicacion;
    @XmlElement(required = true)
    protected String prestadoSiNo;
    @XmlElement(required = true)
    protected LibroType.FechaDevolucion fechaDevolucion;

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
     * Obtiene el valor de la propiedad autor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Define el valor de la propiedad autor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutor(String value) {
        this.autor = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPaginas.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * Define el valor de la propiedad numeroPaginas.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroPaginas(BigInteger value) {
        this.numeroPaginas = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPublicacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Define el valor de la propiedad fechaPublicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPublicacion(XMLGregorianCalendar value) {
        this.fechaPublicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad prestadoSiNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrestadoSiNo() {
        return prestadoSiNo;
    }

    /**
     * Define el valor de la propiedad prestadoSiNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrestadoSiNo(String value) {
        this.prestadoSiNo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDevolucion.
     * 
     * @return
     *     possible object is
     *     {@link LibroType.FechaDevolucion }
     *     
     */
    public LibroType.FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Define el valor de la propiedad fechaDevolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link LibroType.FechaDevolucion }
     *     
     */
    public void setFechaDevolucion(LibroType.FechaDevolucion value) {
        this.fechaDevolucion = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class FechaDevolucion {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;

        /**
         * Obtiene el valor de la propiedad value.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Define el valor de la propiedad value.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

    }

}
