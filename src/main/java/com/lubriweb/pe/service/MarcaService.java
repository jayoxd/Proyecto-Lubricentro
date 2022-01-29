package com.lubriweb.pe.service;

import java.util.List;

import com.lubriweb.pe.model.Marca;


public interface MarcaService {

	
	public List<Marca>findAll();
	public Marca getFindById(Integer id);
	public  Marca save(Marca marca);
	public void delete(Integer id);
	
}
