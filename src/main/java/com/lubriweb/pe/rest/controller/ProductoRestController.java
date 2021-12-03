package com.lubriweb.pe.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.servicios.ProductoServicio;




@RestController
@RequestMapping("/rest/productos")
public class ProductoRestController {
	
	@Autowired
	private ProductoServicio serviciorest;
	
	
    @GetMapping
	public ResponseEntity<Object> buscarTodo() {
		
		List<Producto>  listaFunciones = serviciorest.listarTodo();
		return new ResponseEntity<>(listaFunciones, HttpStatus.OK);
		
		
	}
    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Producto> findById (@PathVariable int id){
    	
    	Producto funcion = serviciorest.buscarPorID(id);
    	
    	ResponseEntity<Producto> rE = null;
    	
    	if (funcion != null) {
    		
    		rE = new ResponseEntity<Producto>(funcion, HttpStatus.OK);
    		
    	}else {
    		
    		rE = new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
    	}
    	
    	return rE;
    	
    }
    
    

}
