package com.lubriweb.pe.restcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubriweb.pe.model.Usuario;
@Service
public class Usuarioservicio {
	@Autowired
	
private Usuariorepository uRepositorio;
	
	
	public List<Usuario> obtenerTodos() {

		return uRepositorio.findAll();
		}



		public void guardar(Usuario u) {

			uRepositorio.save(u);

		}

		public Usuario obtenerUsuario(Integer id) {

			return uRepositorio.getOne(id);


		}

		public void actualizar(Usuario u) {

			uRepositorio.save(u);


		}

		public void eliminar(Integer id) {

			uRepositorio.deleteById(id);


		}
	
}
