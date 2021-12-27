package com.lubriweb.pe.service;

import com.lubriweb.pe.model.Usuario;

public interface UsuarioService {
	
	public abstract void insert(Usuario user);
	public abstract Usuario findById(Integer idUsuario);
	public abstract Usuario findByUsername(String username);


}
