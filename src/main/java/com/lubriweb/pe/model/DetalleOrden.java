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

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "detalle_orden")
public class DetalleOrden implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nombre;
	@Column(length = 45, nullable = false, unique = true)
	private double cantidad;
	@Column
	private double precio;
	@Column
	private double total;
	

	//Muchos Detalles un Producto <-> un Producto Muchos Detalles (Relacion U - M )
	@JoinColumn(name = "IdProducto", referencedColumnName = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonBackReference(value="detord_prod")
	private Producto producto;
	
	@OneToOne	
	private Orden orden;

	
	public DetalleOrden() {
		
	}

	public DetalleOrden(Integer id, String nombre, double cantidad, double precio, double total, Producto producto) {
		
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.producto = producto;
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	

}
