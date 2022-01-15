package com.lubriweb.pe.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.service.ProductoServiceImplement;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class ProductoRestController {
	
	@Autowired
	private ProductoServiceImplement pSrvcImpl;
	
	@GetMapping("api/productos")
	public ResponseEntity<List<Producto>> findAll() {
		
		List<Producto> p = pSrvcImpl.findAll();
		
		if( p.size() > 0) {
			
			return new  ResponseEntity<List<Producto>>(p, HttpStatus.OK);
			
		}else {
			
			return new  ResponseEntity<List<Producto>>(p, HttpStatus.NO_CONTENT);
		}
		
	}
		

}
