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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	@Column(nullable = false, unique = true, length = 45)
	private String nombre;
	@Column
	private String Descripcion;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria", fetch = FetchType.LAZY)
	@JsonBackReference(value="cat_marca")
	private List<Marca> marcas;

	public Categoria() {

	}


	public Categoria(Integer idCategoria, String nombre, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		Descripcion = descripcion;
	}


	public Categoria(Integer idCategoria, String nombre, String descripcion, List<Marca> marcas) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		Descripcion = descripcion;
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
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public List<Marca> getMarcas() {
		return marcas;
	}


	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}


}
