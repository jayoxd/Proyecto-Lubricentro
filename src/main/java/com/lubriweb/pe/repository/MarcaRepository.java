package com.lubriweb.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lubriweb.pe.model.Marca;


@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer>{

}
