package com.lubriweb.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lubriweb.pe.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

}
