package com.lubriweb.pe.restcontroller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lubriweb.pe.model.Categoria;
@Repository
public interface Categoriarepository extends JpaRepository<Categoria, Integer>{

}