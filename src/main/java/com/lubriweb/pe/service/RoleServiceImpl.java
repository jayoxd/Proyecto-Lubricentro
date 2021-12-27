package com.lubriweb.pe.service;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubriweb.pe.model.Rol;
import com.lubriweb.pe.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository rolrepo;
	
	
	@Override
	@Transactional(readOnly = true)
	public Rol findById(Integer idRole) {
		
		return rolrepo.findById(idRole).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Rol findByType(String tipo) {
		
		return rolrepo.findByType(tipo);
	}
	

	@Override
	@Transactional(readOnly = true)
	public Collection<Rol> findAll() {
		
		return rolrepo.findAll();
	}

}
