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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	@Column(nullable=false, unique=true)
	private String nombre;
	@Column
	private String Descripcion;
	
	//Una Categoria Muchos Productos
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	
	public Categoria() {
		
	}


	public Categoria(Integer idCategoria, String nombre, String descripcion, List<Producto> productos) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		Descripcion = descripcion;
		this.productos = productos;
	}


	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	
}
