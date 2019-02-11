package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto_idioma")
@NamedQueries({ @NamedQuery(name = "ProductoIdioma.findAll", query = "SELECT pi FROM ProductoIdioma pi"),
        @NamedQuery(name = "ProductoIdioma.findById_Idioma", query = "SELECT pi FROM ProductoIdioma pi WHERE pi.id_idioma = :id_idioma"),
        @NamedQuery(name = "ProductoIdioma.findByNombre", query = "SELECT pi FROM ProductoIdioma pi WHERE pi.nombre = :nombre") })

public class ProductoIdioma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long cod_idioma;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String nombre;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String descripcion;

    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Producto idProducto;

    public ProductoIdioma() {
    }

    public ProductoIdioma(Long cod_idioma) {
        this.cod_idioma = cod_idioma;
    }

    public ProductoIdioma(Long cod_idioma, String nombre, String description, Producto idProducto){
        this.cod_idioma = cod_idioma;
        this.nombre = nombre;
        this.descripcion = description;
        this.idProducto = idProducto;
    
    }
    
    /**
     * @return Long return the cod_idioma
     */
    public Long getCod_idioma() {
        return cod_idioma;
    }

    /**
     * @param cod_idioma the cod_idioma to set
     */
    public void setCod_idioma(Long cod_idioma) {
        this.cod_idioma = cod_idioma;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Producto return the idProducto
     */
    public Producto getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod_idioma != null ? cod_idioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoIdioma)) {
            return false;
        }
        ProductoIdioma other = (ProductoIdioma) object;
        if ((this.cod_idioma == null && other.cod_idioma != null) || (this.cod_idioma != null && !this.cod_idioma.equals(other.cod_idioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProductoIdioma[ cod_idioma=" + cod_idioma + " ]";
    }


}

    