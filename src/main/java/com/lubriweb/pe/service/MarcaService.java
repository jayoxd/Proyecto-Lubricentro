package com.lubriweb.pe.service;

import java.util.List;
import java.util.Optional;

import com.lubriweb.pe.model.Marca;

public interface MarcaService {

	public  Marca save(Marca marca);
	public Optional<Marca> get(Integer id);
	public void update(Marca marca);
	public void delete(Integer id);
	public List<Marca>findAll();
}
