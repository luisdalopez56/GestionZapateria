package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.codehaus.jackson.annotate.JsonBackReference;

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
@Table(name = "producto")
@NamedQueries({ @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
        @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
        @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.categoria = :categoria") })

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id_producto;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String ruta_imagen;
    
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private ProductoCategoria id_categoria;

    @JoinColumn(name = "id_producto_idioma", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private ProductoCategoria id_producto_idioma;

    public Producto() {
    }

    public Producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public Producto(Long id_producto, String ruta_imagen, ProductoCategoria productoCategoria){
        this.id_producto = id_producto;
        this.ruta_imagen = ruta_imagen;
        this.id_categoria = productoCategoria;
    
    }

    /**
     * @return Long return the id_producto
     */
    public Long getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return String return the ruta_imagen
     */
    public String getRuta_imagen() {
        return ruta_imagen;
    }

    /**
     * @param ruta_imagen the ruta_imagen to set
     */
    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    /**
     * @return ProductoCategoria return the id_categoria
     */
    public ProductoCategoria getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(ProductoCategoria id_categoria) {
        this.id_categoria = id_categoria;
    }

}
