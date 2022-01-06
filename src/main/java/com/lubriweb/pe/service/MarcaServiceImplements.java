package com.lubriweb.pe.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.repository.MarcaRepository;

@Service
public class MarcaServiceImplements implements MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Override
	public Marca save(Marca marca) {
		// TODO Auto-generated method stub
		return marcaRepository.save(marca);
	}

	@Override
	public Optional<Marca> get(Integer id) {
		// TODO Auto-generated method stub
		return marcaRepository.findById(id);
	}

	@Override
	public void update(Marca marca) {
		// TODO Auto-generated method stub
		marcaRepository.save(marca);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		marcaRepository.deleteById(id);

	}

	@Override
	public List<Marca> findAll() {
		// TODO Auto-generated method stub
		return marcaRepository.findAll();
	}

}
