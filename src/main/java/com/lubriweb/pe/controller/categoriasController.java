package com.lubriweb.pe.controller;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lubriweb.pe.model.Categoria;
import com.lubriweb.pe.service.CategoriaService;


@Controller
@RequestMapping("/moduloCategorias")
public class categoriasController {
private final Logger LOGGER = LoggerFactory.getLogger(categoriasController.class);
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@GetMapping("")
	public String listartodo(Model model) {
		model.addAttribute("listacategorias", categoriaservice.findAll());
		return "moduloCategorias/listartodo";
	}

	@GetMapping("/nuevaCategoria")
	public String nuevaCategoria() {
		
		
		return "moduloCategorias/nuevaCategoria";
	}
	@PostMapping("/save")
	public String  save(Categoria categoria) {
		LOGGER.info("este  es el objeto categoria {}",categoria);
		categoriaservice.save(categoria);

		return "redirect:/moduloCategorias";
	}
}
