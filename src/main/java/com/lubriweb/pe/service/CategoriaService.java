package com.lubriweb.pe.service;

import java.util.List;
import java.util.Optional;

import com.lubriweb.pe.model.Categoria;

public interface CategoriaService {

	public Categoria save(Categoria categoria);
	public Optional<Categoria> get(Integer id);
	public void update(Categoria categoria);
	public void delete(Integer id);
	public List<Categoria>findAll();
}
