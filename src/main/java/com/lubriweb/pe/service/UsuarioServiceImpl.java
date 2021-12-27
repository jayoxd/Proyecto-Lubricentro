package com.lubriweb.pe.service;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lubriweb.pe.model.Rol;
import com.lubriweb.pe.model.Usuario;
import com.lubriweb.pe.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; //Inyeccion al Bean passwordEncoder
	
	
	
	
	
	@Override
	@Transactional
	public void insert(Usuario user) {
		
		//Cifrando el password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//Guardar al usuario
		userRepo.save(user);
		
		
	}


	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Integer idUsuario) {
		
		return userRepo.findById(idUsuario).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}

	@Override //Metodo para descubrir si el usuario que intenta loguearse puede pasar como Authenticado o no
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Usuario buscado por username
		Usuario user = this.findByUsername(username);
		
		if(user != null) {
			
			//Coleccion vacio de roles
			Collection<GrantedAuthority> roles = new ArrayList<>();
			
			//Agregar roles de usuario a la coleccion roles
			for(Rol role: user.getItemsRol()) {
				
				roles.add(new SimpleGrantedAuthority("ROLE_" +role.getTipo()));
				
			}
			
			//Coleccion cargado
			
			return new User(user.getUsername(), user.getPassword(), user.getEstado().equals("ACTIVE"),
					   true, true, true,roles);
		}
		
		throw new UsernameNotFoundException ("Revise Su Email o Usuario");
	}

	
}
