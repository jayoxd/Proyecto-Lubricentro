package com.lubriweb.pe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;
	@Column(unique = true, nullable = false)
	private String Tipo;
	
	//Muchos roles tiene Muchos Usuarios
	//Lado inverse
	@ManyToMany(mappedBy = "itemsRol") //referencia o comunicacion o el lazo que los une -> a la otra coleccion itemsRol
	private Set<Usuario> itemsUsuario = new HashSet<>();
	
	
	public Rol() {
		
	}


	public Rol(Integer idRole, String tipo, Set<Usuario> itemsUsuario) {
		
		this.idRole = idRole;
		Tipo = tipo;
		this.itemsUsuario = itemsUsuario;
	}


	public Integer getIdRole() {
		return idRole;
	}


	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}


	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public Set<Usuario> getItemsUsuario() {
		return itemsUsuario;
	}


	public void setItemsUsuario(Set<Usuario> itemsUsuario) {
		this.itemsUsuario = itemsUsuario;
	}
	
	
	

}
