package com.lubriweb.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lubriweb.pe.model.Producto;

@Repository
public interface ProductoRepositoy  extends JpaRepository<Producto,Integer>{

}
