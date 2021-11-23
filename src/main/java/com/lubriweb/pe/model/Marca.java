package com.lubriweb.pe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "marca")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;
	private String nombre;
	private String proveedor;
	
	@OneToMany(mappedBy = "marcas")
	private List<Producto> productos;
	
	

	public Marca() {
		
	}




	public Marca(Integer idMarca, String nombre, String proveedor) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.proveedor = proveedor;
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



	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", nombre=" + nombre + ", proveedor=" + proveedor + ", productos="
				+ productos + "]";
	}


	
	
}
