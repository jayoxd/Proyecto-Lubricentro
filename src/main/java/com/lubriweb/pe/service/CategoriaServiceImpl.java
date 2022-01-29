package com.lubriweb.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired

	private CategoriaRepository catrepo;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {

		return catrepo.findAll();
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {

		return catrepo.save(categoria);
	}

	@Override
	@Transactional
	public Categoria getFindById(Integer id) {

		return catrepo.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {

		catrepo.deleteById(id);
	}

}
