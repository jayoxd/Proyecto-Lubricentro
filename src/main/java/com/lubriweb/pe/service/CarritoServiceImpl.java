package com.lubriweb.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubriweb.pe.model.Carrito;
import com.lubriweb.pe.repository.CarritoRepository;

@Service
public class CarritoServiceImpl  implements CarritoService{
	
	@Autowired
	private CarritoRepository cartrepo;
	

	@Override
	public Carrito save(Carrito carrito) {
		
		return cartrepo.save(carrito);
	}

}
