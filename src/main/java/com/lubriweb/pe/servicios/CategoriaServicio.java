package com.lubriweb.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.repository.CategoriaRepository;


@Service
@Transactional
public class CategoriaServicio {
	@Autowired
	private CategoriaRepository repositorio;

	public CategoriaServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Categoria> buscarTodo() {
		return (List<Categoria>) repositorio.findAll();  
	}
	
	

	public Categoria crear(Categoria categoria) {
		return repositorio.save(categoria);
	}

	public Categoria actualizar(Categoria categoriaActualizar) {
		Categoria categoriaActual = repositorio.findById(categoriaActualizar.getIdCategoria()).get();
		categoriaActual.setIdCategoria(categoriaActualizar.getIdCategoria());
		categoriaActual.setDescripcion(categoriaActualizar.getDescripcion());;
	
		Categoria categoriaActualizado = repositorio.save(categoriaActual);
		return categoriaActualizado;
	}

	public Categoria buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
