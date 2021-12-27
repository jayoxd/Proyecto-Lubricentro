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
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCarrito;
	
	@Column
	private int cantidad;
	
	//Muchos productos pueden ser agregados al carrito 
	@JoinColumn(name = "IdProducto", referencedColumnName = "idProducto")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Producto producto;
	
	//Un usuario puede agregar muchos productos al carrito
	@JoinColumn(name = "IdUsuario", referencedColumnName = "idUsuario")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Usuario usuario;
	
	
	public Carrito() {
		
	}


	public Carrito(Integer idCarrito, int cantidad, Producto producto, Usuario usuario) {
		
		this.idCarrito = idCarrito;
		this.cantidad = cantidad;
		this.producto = producto;
		this.usuario = usuario;
	}


	public Integer getIdCarrito() {
		return idCarrito;
	}


	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
