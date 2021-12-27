package com.lubriweb.pe.service;

import java.util.Collection;

import com.lubriweb.pe.model.Rol;

public interface RoleService {

	public abstract Rol findById(Integer idRole);
	public abstract Rol findByType(String tipo);
	public abstract Collection<Rol> findAll(); 
	
}
