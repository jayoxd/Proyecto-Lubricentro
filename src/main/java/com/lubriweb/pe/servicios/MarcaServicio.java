package com.lubriweb.pe.servicios;

import java.util.List;

import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.repository.MarcaRepository;

public class MarcaServicio {
	
	
	private MarcaRepository repositorio;

	public MarcaServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Marca> buscarTodo() {
		return (List<Marca>) repositorio.findAll();  
	}

	public Marca crear(Marca marca) {
		return repositorio.save(marca);
	}

	public Marca actualizar(Marca MarcaActualizar) {
		Marca MarcaActual = repositorio.findById(MarcaActualizar.getIdMarca()).get();
		MarcaActual.setIdMarca(MarcaActualizar.getIdMarca());
		MarcaActual.setNombre(MarcaActualizar.getNombre());;
		MarcaActual.setProveedor(MarcaActualizar.getProveedor());;
	
		Marca MarcaActualizado = repositorio.save(MarcaActual);
		return MarcaActualizado;
	}

	public Marca buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
