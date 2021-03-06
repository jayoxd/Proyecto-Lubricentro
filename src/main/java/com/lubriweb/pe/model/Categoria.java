package com.lubriweb.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
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
	@Column(nullable = false, unique = true, length = 45)
	private String nombre;
	@Column
	private String descripcion;

	// una Categoria Muchas Marcas <-> Muchas Marcas una Categoria (Relacion U - M)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Marca> marcas = new ArrayList<>();

	public Categoria() {

	}

	public Categoria(Integer idCategoria) {

		this.idCategoria = idCategoria;

	}

	public Categoria(Integer idCategoria, String nombre, String descripcion, List<Marca> marcas) {

		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marcas = marcas;
	}

	public Categoria(String nombre, String descripcion, List<Marca> marcas) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marcas = marcas;
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
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

}
