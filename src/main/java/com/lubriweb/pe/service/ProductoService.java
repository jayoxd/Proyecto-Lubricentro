package com.lubriweb.pe.service;

import java.util.List;
import com.lubriweb.pe.model.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	public Producto getFindById(Integer id);
	public Producto save(Producto producto);
	public void delete(Integer id);
	
}
  