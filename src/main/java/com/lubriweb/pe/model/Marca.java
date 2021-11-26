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
@Table(name = "marca")
public class Marca implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	@Column
	private String nombre;
	@Column
	private String proveedor;
	
	//Una Marca Muchos Productos
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "marcas", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	

	public Marca() {
		
	}



	public Marca(Integer idMarca, String nombre, String proveedor, List<Producto> productos) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.productos = productos;
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



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	
}
