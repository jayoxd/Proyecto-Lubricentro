package com.lubriweb.pe.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lubriweb.pe.model.Rol;
import com.lubriweb.pe.model.Usuario;
import com.lubriweb.pe.service.RoleService;
import com.lubriweb.pe.service.UsuarioService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private RoleService rolesrvc;
	
	@Autowired
	private UsuarioService usersrvc;
	

	//@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	@GetMapping(value = {"/", "/index"})
	public String Inicio() {

		return "index";

	}
	
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String login() {

		return "login";

	}
	
	@GetMapping("/Nosotros")
	public String Nosotros() {

		return "Nosotros";

	}
	
	
	
	@GetMapping("/register")
	public String showFormRegister(Model model) {
		
		Usuario usuario = new Usuario();
		Collection<Rol>  itemsRol = rolesrvc.findAll();
		
		model.addAttribute("usuario",usuario); //Usuario vacio
		model.addAttribute("roles",itemsRol); 
		
		
		
		return "registration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Registration(Usuario usuario) { //Usuario Cargado
		
		usersrvc.insert(usuario);
		
		return "registration_success";
	}

	//@RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping("/user")
	public String user() {

		return "user";

	}

	//@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@GetMapping("/admin")
	public String admin() {

		return "admin";

	}

	//@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	@GetMapping("/access_denied")
	public String access_denied() {

		return "access_denied";

	}


	//@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		//Llamar al usuario aunthenticado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		//si existe el usuario authenticado
		if (auth != null)

			new SecurityContextLogoutHandler().logout(request, response, auth);//cerrar sesion

		//redireccionar a login
		return "redirect:login?logout";

	}

}
