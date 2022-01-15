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
@Table(name = "marca")
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	@Column(length = 45, nullable = false, unique = true)
	private String nombre;
	@Column
	private String proveedor;
	
	// Muchas Marcas una categoria <-> Una Categoria Muchas marcas (Relacion U - M)
	@JoinColumn(name = "IdCategoria", referencedColumnName = "idCategoria")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonBackReference(value="marca_cate")
	private Categoria categoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "marcas", fetch = FetchType.LAZY)
	private List<Producto> productos;



	public Marca() {

	}


	public Marca(Integer idMarca, String nombre, String proveedor, Categoria categoria) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.categoria = categoria;
	}


	public Integer getIdMarca() {
		return idMarca;
	}


	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
}
