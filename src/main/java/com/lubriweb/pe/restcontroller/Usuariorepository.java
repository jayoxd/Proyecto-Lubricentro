package com.lubriweb.pe.restcontroller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lubriweb.pe.model.Usuario;
@Repository
public interface Usuariorepository extends JpaRepository<Usuario, Integer>{

}
