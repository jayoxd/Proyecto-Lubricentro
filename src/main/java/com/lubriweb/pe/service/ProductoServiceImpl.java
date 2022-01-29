package com.lubriweb.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubriweb.pe.model.Producto;
import com.lubriweb.pe.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired

	private ProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {

		return productoRepository.findAll();
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {

		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public Producto getFindById(Integer id) {

		return productoRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {

		productoRepository.deleteById(id);
	}

}
