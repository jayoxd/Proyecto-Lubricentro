package com.lubriweb.pe.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaServiceImpl  implements CategoriaService{

	@Autowired
	
	private CategoriaRepository categoriarepository;

	@Override
	public Categoria save(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriarepository.save(categoria);
	}

	
	@Override
	public Categoria getFindById(Integer id) {
		// TODO Auto-generated method stub
		return categoriarepository.findById(id).get();
	}

	
	
	/*
	 * @Override public Optional<Categoria> getFindId(Integer id) { // TODO
	 * Auto-generated method stub return categoriarepository.findById(id); }
	 */

	@Override
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriarepository.save(categoria);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		categoriarepository.deleteById(id);
	}

	@Override
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriarepository.findAll();
	}

	

}
