
package org.example.jaxbPrueba;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para socioType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="socioType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoSocio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nombreSocio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apellidoSocio" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="2"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="librosPrestados"&gt;
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
@XmlType(name = "socioType", propOrder = {
    "codigoSocio",
    "nombreSocio",
    "apellidoSocio",
    "telefono",
    "librosPrestados"
})
public class SocioType {

    @XmlElement(required = true)
    protected String codigoSocio;
    @XmlElement(required = true)
    protected String nombreSocio;
    @XmlElement(required = true)
    protected List<String> apellidoSocio;
    @XmlElement(required = true)
    protected BigInteger telefono;
    @XmlElement(required = true)
    protected SocioType.LibrosPrestados librosPrestados;

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
     * Gets the value of the apellidoSocio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the apellidoSocio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApellidoSocio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getApellidoSocio() {
        if (apellidoSocio == null) {
            apellidoSocio = new ArrayList<String>();
        }
        return this.apellidoSocio;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTelefono(BigInteger value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad librosPrestados.
     * 
     * @return
     *     possible object is
     *     {@link SocioType.LibrosPrestados }
     *     
     */
    public SocioType.LibrosPrestados getLibrosPrestados() {
        return librosPrestados;
    }

    /**
     * Define el valor de la propiedad librosPrestados.
     * 
     * @param value
     *     allowed object is
     *     {@link SocioType.LibrosPrestados }
     *     
     */
    public void setLibrosPrestados(SocioType.LibrosPrestados value) {
        this.librosPrestados = value;
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
    public static class LibrosPrestados {

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

}
