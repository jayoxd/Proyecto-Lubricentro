package com.lubriweb.pe.restcontroller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lubriweb.pe.model.Usuario;

public interface Usuariorepository extends JpaRepository<Usuario, Integer>{

}
