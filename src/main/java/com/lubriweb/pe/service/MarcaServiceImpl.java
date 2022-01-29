package com.lubriweb.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository marcrepo;

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findAll() {

		return marcrepo.findAll();
	}

	@Override
	@Transactional
	public Marca save(Marca marca) {

		return marcrepo.save(marca);
	}

	@Override
	@Transactional
	public Marca getFindById(Integer id) {

		marcrepo.findById(id).get();

		return null;
	}

	@Override
	@Transactional
	public void delete(Integer id) {

		marcrepo.deleteById(id);

	}

}
