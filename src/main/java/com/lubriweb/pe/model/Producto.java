package com.lubriweb.pe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String imagen;
	@Column
	private double precio;
	@Column
	private int cantidad;

	// Muchos Productos una Marca <-> Una Marca Muchos Productos (Relacion M - U)
	@JoinColumn(name = "IdMarca", referencedColumnName = "idMarca")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonBackReference(value="prod_marc")
	private Marca marcas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
	@JsonBackReference(value="prod_det")
	private List<DetalleOrden> detalles;

	public Producto() {

	}

	public Producto(Integer idProducto, String nombre, String descripcion, String imagen, double precio, int cantidad,
			Marca marcas, List<DetalleOrden> detalles) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.marcas = marcas;
		this.detalles = detalles;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Marca getMarcas() {
		return marcas;
	}

	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}

	public List<DetalleOrden> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleOrden> detalles) {
		this.detalles = detalles;
	}

	
}
