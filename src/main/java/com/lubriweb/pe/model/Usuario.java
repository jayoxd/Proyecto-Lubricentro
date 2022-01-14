package com.lubriweb.pe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


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

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column()
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
	@Column(nullable = false)
	private String estado = StateType.ACTIVE.name();

    
    //Muchos Usuarios tiene Muchos Roles
    @ManyToMany(fetch = FetchType.EAGER)
	@JsonBackReference(value="usu_rol")

    @JoinTable(name = "usuario_rol",
    		joinColumns=@JoinColumn(name="id_usuario",nullable=false,
    		    foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(id_usuario) references usuario(id_usuario)")),
    		inverseJoinColumns=@JoinColumn(name="id_role",nullable=false,
    		    foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_role) references rol(id_role)")))
    private Set<Rol>  itemsRol = new HashSet<>();
	
	
	public Usuario() {
		
	}


	public Usuario(Integer idUsuario, String nombre, String username, String email, String direccion, String telefono,
			String password, String estado, Set<Rol> itemsRol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.password = password;
		this.estado = estado;
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Set<Rol> getItemsRol() {
		return itemsRol;
	}


	public void setItemsRol(Set<Rol> itemsRol) {
		this.itemsRol = itemsRol;
	}




	
	


}
