package com.lubriweb.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lubriweb.pe.model.Rol;

public interface RoleRepository extends JpaRepository<Rol, Integer>{
	
	@Query(value="select * from rol where tipo = ?1", nativeQuery = true)
	public abstract Rol findByType(String tipo);

}
