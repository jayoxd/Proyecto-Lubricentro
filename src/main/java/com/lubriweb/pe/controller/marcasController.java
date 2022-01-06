package com.lubriweb.pe.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.model.Marca;
import com.lubriweb.pe.service.MarcaService;


@Controller
@RequestMapping("/moduloMarcas")
public class marcasController {

	private final Logger LOGGER = LoggerFactory.getLogger(marcasController.class);
	
	@Autowired
	private MarcaService marcaservice;
	
	@GetMapping("")
	public String listartodo(Model model) {
		model.addAttribute("listamarcas", marcaservice.findAll());
		return "moduloMarcas/listartodo";
	}

	@GetMapping("/nuevaMarca")
	public String nuevaMarca() {
		
		
		return "moduloMarcas/nuevaMarca";
	}
	@PostMapping("/save")
	public String  save(Marca marca) {
		LOGGER.info("este  es el objeto marca {}",marca);
		
		Categoria c=new Categoria(1, "","");
		
		marca.setCategoria(c);
		marcaservice.save(marca);

		return "redirect:/moduloMarcas";
	}
}
