package com.lubriweb.pe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Marca marcas;
	
	@ManyToOne
	private Categoria categorias;
	
	
	
	public Producto() {
		
	}

    


	public Producto(Integer idProducto, String nombre, String descripcion, String imagen, double precio, int cantidad,
			Usuario usuario, Marca marcas, Categoria categorias) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.usuario = usuario;
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
	
	

	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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




	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", usuario=" + usuario
				+ ", marcas=" + marcas + ", categorias=" + categorias + "]";
	}







	

}
