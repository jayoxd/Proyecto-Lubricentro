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

import com.lubriweb.pe.model.Categoria;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Categoriacontroller {
	@Autowired
	private Categoriaservicio cSrvc;
	
	
	
	@GetMapping("api/categoriarest")
	public List<Categoria> obtenerCategoria() {

	return cSrvc.obtenerTodos();

	}


	@PostMapping("api/categoriarest")
	public Categoria guardarCategoria(@RequestBody Categoria c) {

	System.out.println(c);

	cSrvc.crear(c);

	return c;
	}


	@GetMapping("api/categoriarest/{id}")
	public Categoria obtenerOne(@PathVariable("id") Integer id) {


	return cSrvc.obtenerCategoria(id);

	}

	@PutMapping("api/categoriarest")
	public void actualizarCategoria(@RequestBody Categoria c) {

	cSrvc.actualizar(c);


	}

	@DeleteMapping("api/categoriarest/{id}")
	public void eliminar(@PathVariable("id") Integer id) {

	cSrvc.eliminar(id);


	}
}
