package com.lubriweb.pe.restcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubriweb.pe.model.Categoria;
@Service
public class Categoriaservicio {
	@Autowired
	
private Categoriarepository cRepositorio;
	
	
	public List<Categoria> obtenerTodos() {

		return cRepositorio.findAll();
		}



		public void guardar(Categoria c) {

			cRepositorio.save(c);

		}

		public Categoria obtenerCategoria(Integer id) {

			return cRepositorio.getOne(id);


		}

		public void actualizar(Categoria c) {

			cRepositorio.save(c);


		}

		public void eliminar(Integer id) {

			cRepositorio.deleteById(id);


		}
	
}
