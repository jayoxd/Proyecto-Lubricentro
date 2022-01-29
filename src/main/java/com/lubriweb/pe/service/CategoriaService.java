package com.lubriweb.pe.service;

import java.util.List;


import com.lubriweb.pe.model.Categoria;


public interface CategoriaService {

	
	public List<Categoria>findAll();
	public Categoria getFindById(Integer id);
	public Categoria save(Categoria categoria);
	public void delete(Integer id);

	
}
