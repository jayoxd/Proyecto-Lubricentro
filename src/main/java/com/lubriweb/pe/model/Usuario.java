package com.lubriweb.pe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column
	private String nombre;
	@Column(unique = true , nullable = false)
	private String username;
	@Column
	private String email;
	@Column
	private String direccion;
	@Column(unique = true)
	private String telefono;
	@Column(nullable = false)
	private String password;

	
	//Un Usuario Muchos Productos
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	//Un Usuario Muchas Ordenes
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenUsuarios", fetch = FetchType.LAZY)
	private List<Orden> ordenes;
    
    //Muchos Usuarios tiene Muchos Roles
    @ManyToMany
    @JoinTable(name = "usuario_rol",
    		joinColumns=@JoinColumn(name="id_usuario",nullable=false,
    		    foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_usuario) references usuario(id_usuario)")),
    		inverseJoinColumns=@JoinColumn(name="id_role",nullable=false,
    		    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_role) references rol(id_role)")))
    private Set<Rol>  itemsRol = new HashSet<>();
	
	
	public Usuario() {
		
	}


	public Usuario(Integer idUsuario, String nombre, String username, String email, String direccion, String telefono,
			String password, List<Producto> productos, List<Orden> ordenes, Set<Rol> itemsRol) {
	
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.password = password;
		this.productos = productos;
		this.ordenes = ordenes;
		this.itemsRol = itemsRol;
	}


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public List<Orden> getOrdenes() {
		return ordenes;
	}


	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}


	public Set<Rol> getItemsRol() {
		return itemsRol;
	}


	public void setItemsRol(Set<Rol> itemsRol) {
		this.itemsRol = itemsRol;
	}
	
	
	

}
