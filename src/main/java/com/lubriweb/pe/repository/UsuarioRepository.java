package com.lubriweb.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lubriweb.pe.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	@Query(value="select * from usuario where username = ?1", nativeQuery = true)
	public abstract Usuario findByUsername(String username);

}
