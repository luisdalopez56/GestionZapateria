package com.iesvdc.acceso.zapateria.gestionzapateria;



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
@Table(name="producto_idioma") //tabla en la base de datos
public class ProductoIdioma {
	
    @Id //clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //referencia a AUTOINCREMENT
    private Long id;
    @Column(name="cod_idioma")//nombre del campo en tabla si es distinto al del POJO
    private String codIdioma;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Producto producto;
	public String getCodIdioma() {
		return codIdioma;
	}
	public void setCodIdioma(String codIdioma) {
		this.codIdioma = codIdioma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public ProductoIdioma(String codIdioma, String nombre, String descripcion, Producto producto) {
		super();
		this.codIdioma = codIdioma;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.producto = producto;
	}
	
	public ProductoIdioma() {
		
	}
    
    
    
}
