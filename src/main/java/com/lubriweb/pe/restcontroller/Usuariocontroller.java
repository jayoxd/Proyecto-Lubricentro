package com.lubriweb.pe.restcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lubriweb.pe.model.Usuario;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Usuariocontroller {
	@Autowired
	private Usuarioservicio uSrvc;
	
	
	
	@GetMapping("api/usuariorest")
	public List<Usuario> obtenerUsuario() {

	return uSrvc.obtenerTodos();

	}


	@PostMapping("api/usuariorest")
	public Usuario guardarUsuario(@RequestBody Usuario u) {

	System.out.println(u);

	uSrvc.guardar(u);

	return u;
	}


	@GetMapping("api/usuariorest/{id}")
	public Usuario obtenerOne(@PathVariable("id") Integer id) {


	return uSrvc.obtenerUsuario(id);

	}

	@PutMapping("api/usuariorest")
	public void actualizarUsuario(@RequestBody Usuario u) {

		uSrvc.actualizar(u);


	}

	@DeleteMapping("api/usuariorest/{id}")
	public void eliminar(@PathVariable("id") Integer id) {

		uSrvc.eliminar(id);


	}
}
