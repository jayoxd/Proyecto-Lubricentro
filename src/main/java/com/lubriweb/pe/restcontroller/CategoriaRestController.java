package com.lubriweb.pe.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.service.CategoriaServiceImpl;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class CategoriaRestController {

	@Autowired
	private CategoriaServiceImpl cSrvcImpl;

	@GetMapping("api/categorias")
	public ResponseEntity<List<Categoria>> findAll() {

		List<Categoria> c = cSrvcImpl.findAll();

		if (c.size() > 0) {

			return new ResponseEntity<List<Categoria>>(c, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Categoria>>(c, HttpStatus.NO_CONTENT);
		}

	}
	
	
	
	@PostMapping("api/categorias")
	public Categoria guardarCategoria (@RequestBody Categoria cate) {
		
		System.out.println(cate);

		return cate;
		
	}
	
	
	

	@GetMapping(value = "api/categorias/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable int id) {

		Categoria cat = cSrvcImpl.getFindById(id);

		ResponseEntity<Categoria> rE = null;

		if (cat != null) {

			rE = new ResponseEntity<Categoria>(cat, HttpStatus.OK);

		} else {

			rE = new ResponseEntity<Categoria>(cat, HttpStatus.NO_CONTENT);

		}

		return rE;

	}


}
