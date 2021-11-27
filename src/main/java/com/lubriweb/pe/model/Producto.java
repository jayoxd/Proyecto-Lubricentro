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
	
	private int estado;
	
	
	
	//Muchos Usuarios un Producto
	@JoinColumn(name = "IdUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Usuario usuarios;
	
	//Muchos Productos una Marca
	@JoinColumn(name = "IdMarca", referencedColumnName = "idMarca")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Marca marcas;
	
	//Muchos Productos una Categoria
	@JoinColumn(name = "IdCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Categoria categorias;
	
	
	
	public Producto() {
		
	}



	public Producto(Integer idProducto, String nombre, String descripcion, String imagen, double precio, int cantidad,
			Usuario usuarios, Marca marcas, Categoria categorias) {
		
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.usuarios = usuarios;
		this.marcas = marcas;
		this.categorias = categorias;
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



	public Usuario getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}



	public Marca getMarcas() {
		return marcas;
	}



	public void setMarcas(Marca marcas) {
		this.marcas = marcas;
	}



	public Categoria getCategorias() {
		return categorias;
	}



	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}

	
	
    

	
	
}
