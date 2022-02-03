package com.lubriweb.pe.service;

import java.util.List;

import com.lubriweb.pe.model.Orden;

public interface OrdenService {
	
	public List<Orden> findAll();
	public Orden save(Orden orden);
	public String generarNumeroOrden();
	

}
