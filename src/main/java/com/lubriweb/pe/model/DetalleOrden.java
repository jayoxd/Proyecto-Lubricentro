package com.lubriweb.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle")
public class DetalleOrden implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nombre;
	@Column
	private double cantidad;
	@Column
	private double precio;
	@Column
	private double total;
	
	
	@OneToOne	
	private Orden orden;
	
	//Muchos Productos en un Detalle de Orden
	@JoinColumn(name = "IdProducto", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Producto productos;
	
	
	public DetalleOrden() {
		
	}


	public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total, Orden orden,
			Producto productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.orden = orden;
		this.productos = productos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Orden getOrden() {
		return orden;
	}


	public void setOrden(Orden orden) {
		this.orden = orden;
	}


	public Producto getProductos() {
		return productos;
	}


	public void setProductos(Producto productos) {
		this.productos = productos;
	}
	
	


	
	

}
